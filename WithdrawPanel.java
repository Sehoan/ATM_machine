import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WithdrawPanel extends JPanel {
    private Atm atm;
    private JPanel panels;
    private CardLayout layout;

    private JLabel headingLabel;
    private JLabel amountLabel, statusLabel;
    private JTextField amountField;
    private JButton depositButton, cancelButton;

    public WithdrawPanel(Atm atm, JPanel panels, CardLayout layout) {
        this.atm = atm;
        this.layout = layout;
        this.panels = panels;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // initialization
        headingLabel = new JLabel("Withdraw");
        amountLabel = new JLabel("amount");
        statusLabel = new JLabel("");
        amountField = new JTextField(10);
        depositButton = new JButton("withdraw");
        cancelButton = new JButton("cancel");

        depositButton.addActionListener(new withdrawListener());
        cancelButton.addActionListener(new cancelListener());

        JPanel mainContent = new JPanel();
        mainContent.add(amountLabel);
        mainContent.add(amountField);
        mainContent.add(depositButton);

        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headingLabel);
        add(mainContent);
        add(statusLabel);
        add(cancelButton);
    }

    private class withdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String amount = amountField.getText();
            if (amount.equals("")) {
                statusLabel.setText("Please fill in the field");
            } else {
                boolean success = atm.withdraw(amount);
                if (success) {
                    statusLabel.setText("Withdraw Completed!");
                } else {
                    statusLabel.setText("Withdraw Failed => Insufficient Balance");
                }
            }
        }
    }

    private class cancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            amountField.setText("");
            statusLabel.setText("");
            layout.show(panels, "menu");
        }
    }
}
