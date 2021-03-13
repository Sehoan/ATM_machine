import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransferPanel extends JPanel {
    private Atm atm;
    private JPanel panels;
    private CardLayout layout;

    private JLabel headingLabel;
    private JLabel numberLabel, amountLabel, statusLabel;
    private JTextField numberField, amountField;
    private JButton sendButton, cancelButton;

    public TransferPanel(Atm atm, JPanel panels, CardLayout layout) {
        this.atm = atm;
        this.layout = layout;
        this.panels = panels;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // initialization
        headingLabel = new JLabel("Transfer");
        statusLabel = new JLabel("");
        numberLabel = new JLabel("Account Number");
        amountLabel = new JLabel("amount");
        numberField = new JTextField(10);
        amountField = new JTextField(10);
        sendButton = new JButton("Send");
        cancelButton = new JButton("Cancel");

        sendButton.addActionListener(new sendListener());
        cancelButton.addActionListener(new cancelListener());

        JPanel numberPanel = new JPanel();
        numberPanel.add(numberLabel);
        numberPanel.add(numberField);
        JPanel amountPanel = new JPanel();
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);

        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numberPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        amountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headingLabel);
        add(numberPanel);
        add(amountPanel);
        add(statusLabel);
        add(sendButton);
        add(cancelButton);
    }

    private class sendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String amount = amountField.getText();
            String number = numberField.getText();
            if (amount.equals("") || number.equals("")) {
                statusLabel.setText("Please fill in all the fields");
            } else {
                String msg = atm.transfer(amount, number);
                statusLabel.setText(msg);
            }
        }
    }

    private class cancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            numberField.setText("");
            amountField.setText("");
            statusLabel.setText("");
            layout.show(panels, "menu");
        }

    }

}
