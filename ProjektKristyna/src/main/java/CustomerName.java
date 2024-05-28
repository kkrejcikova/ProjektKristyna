import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CustomerName extends JFrame {
        //atributy
    private JPanel panel;
    private JTextField nameField, numberField;
    private JLabel nameLabel, numberLabel;
    private JButton confirm;

    public CustomerName() throws HeadlessException {
        // nastavuji atrbibut na první hodnotu

        panel = new JPanel();
        //nastavit layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        nameLabel = new JLabel();
        nameLabel.setText("Jméno");
        panel.add(nameLabel);

        // nastavuji atrbibut na první hodnotu
        nameField = new JTextField();
        // upravíme JTextField
        nameField.setColumns(20);
        panel.add(nameField);

        numberLabel = new JLabel();
        numberLabel.setText("Tel. číslo");
        panel.add(numberLabel);

        // nastavuji atrbibut na první hodnotu
        numberField = new JTextField();
        // upravíme JTextField
        numberField.setColumns(20);
        panel.add(numberField);

        confirm = new JButton();
        confirm.setText("Potvrdit");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String number = numberField.getText();

                DBConnect dbConnect = new DBConnect();
                try {
                    dbConnect.addOrder(name, number);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
                Commission newWindow = new Commission();
                newWindow.setVisible(true);
            }
        });
        panel.add(confirm);

        setSize(500,500);
        setTitle("Company!");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}