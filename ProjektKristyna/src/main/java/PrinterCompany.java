import java.sql.SQLException;
import java.util.ArrayList;

public class PrinterCompany {
    private ArrayList <Customer> customers;
    private ArrayList<Employee> employees;
    private ArrayList<Order> orders;

    private DBConnect database;

    public PrinterCompany(){
        database = new DBConnect();
        customers = new ArrayList<>();
        employees = new ArrayList<>();
        orders = new ArrayList<>();
    }
    public void addCustomer (Customer customer){
        //customers.add(customer);
        database.insertCustomer(customer.getName());
    }
    /*public ArrayList<String> getAllEmployees() throws SQLException {
        ArrayList<String> employeeNames = new ArrayList<>();
        for (Employee employee: database.readEmployees()){
            employeeNames.add(employee.getName());
        }
        return employeeNames;
    }*/

    public void removeCustomer (Customer customer){
        customers.remove(customer);
        database.deleteCustomer(customer.getName());
    }

    public void addEmployee (Employee employee) {

        employees.add(employee);
    }

    public void removeEmployee (Employee employee){
        employees.remove(employee);
    }

    public void addOrder (Order order){
        orders.add(order);
    }

    public void removeOrder (Order order){
        orders.remove(order);
    }
}
