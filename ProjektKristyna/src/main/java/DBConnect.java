import java.sql.*;
import java.util.ArrayList;


public class DBConnect {
    private static String url;
    private Connection connection;
    public DBConnect() {
        connect();
    }

    public void connect() {
        url = "jdbc:sqlite::resource:PrinterCompany.db";
        Connection conn = null;
        try {
            // db parameters

            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public void executeSQL(String sql) {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void insertCustomer(String nameCustomer) {
        String sql = "INSERT INTO Customer(name) VALUES('" + nameCustomer + "')" ;
        executeSQL(sql);
    }

    public void addOrder(String name, String number) throws SQLException {
        String sql = "INSERT INTO Users(name, number) VALUES(?,?)";

        try (
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, number);


            int affectedRows = pstmt.executeUpdate();
            System.out.println("Number of rows affected: " + affectedRows);

            // Verify insertion
            String verifySql = "SELECT * FROM Order";
            try (PreparedStatement verifyPstmt = connection.prepareStatement(verifySql)) {

                ResultSet rs = verifyPstmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Inserted Users - ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", number: " + rs.getString("number"));
                }
            }
        }
    }


    /*public void addOrder(String name, String number) throws SQLException {
        String sql = "INSERT INTO Order(name, number, ) VALUES(?,?)";

        try (
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            executeSQL(sql);
        }
    }*/


    /*public ArrayList<Employee> readEmployees() throws SQLException {
        String sql = "SELECT id, name, position FROM Employee";
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ArrayList<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String position = rs.getString("position");
            employees.add(new Employee(id, name, position));
        }
        return employees;
    }*/

    public void deleteCustomer(String name) {
    }
}