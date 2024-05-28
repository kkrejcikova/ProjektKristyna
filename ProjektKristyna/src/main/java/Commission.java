import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Commission extends JFrame{
    private JPanel panel;
    private JRadioButton deliveryRadio1, deliveryRadio2, orderRadio;
    private JLabel deliveryOptionLabel, emailLabel, dateLabel, titleLabel, amountLabel, orderLabel;
    private JComboBox dateBox, orderBox;
    private JButton nextButton;
    private JTextField emailField;


    public Commission() throws HeadlessException {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        deliveryOptionLabel = new JLabel("Zde zvolte pouze jednu z možností objednání:");
        gb.gridx = 0;
        gb.gridy = 0;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        panel.add(deliveryOptionLabel, gb);

        deliveryRadio1 = new JRadioButton("Objednat přes email");
        gb.gridx = 0;
        gb.gridy = 1;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        panel.add(deliveryRadio1, gb);

        emailField = new JTextField();
        gb.gridx = 1;
        gb.gridy = 1;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        emailField.setColumns(20);
        panel.add(emailField, gb);

        deliveryRadio2 = new JRadioButton("Objednat na prodejně");
        gb.gridx = 0;
        gb.gridy = 2;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        panel.add(deliveryRadio2, gb);

        dateBox = new JComboBox();
        gb.gridx = 1;
        gb.gridy = 2;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        panel.add(dateBox, gb);
        dateBox.addItem("Pondělí 7-15");
        dateBox.addItem("Úterý 7-15");
        dateBox.addItem("Středa 7-13");
        dateBox.addItem("Čtvrtek 7-15");
        dateBox.addItem("Pátek 9-13");

        add(panel);

        setTitle("Objednávka");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
