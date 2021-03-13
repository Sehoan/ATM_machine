import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreatePanel extends JPanel {
    private Atm atm;
    private JPanel panels;
    private CardLayout layout;

    private JLabel headingLabel;
    private JLabel account, password;
    private JTextField accountField, passwordField;
    private JButton signupButton, cancelButton;

    public CreatePanel(Atm atm, JPanel panels, CardLayout layout) {
        this.atm = atm;
        this.layout = layout;
        this.panels = panels;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //initialization
        headingLabel = new JLabel("Sign Up");
        account = new JLabel("AccountHolder");
        password = new JLabel("Password");
        accountField = new JTextField(20);
        passwordField = new JTextField(20);
        signupButton = new JButton("Sign UP!");
        cancelButton = new JButton("Cancel");


        JPanel accountPanel = new JPanel();
        accountPanel.add(account);
        accountPanel.add(accountField);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(password);
        passwordPanel.add(passwordField);

        signupButton.addActionListener(new signupListener());
        cancelButton.addActionListener(new cancelListener());

        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        accountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headingLabel);
        add(accountPanel);
        add(passwordPanel);
        add(signupButton);
        add(cancelButton);
    }

    private class signupListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent event) {
            atm.createAccount(accountField.getText(),passwordField.getText());
            layout.show(panels, "login");

            accountField.setText("");
            passwordField.setText("");
        }

    }
    private class cancelListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent event) {
            accountField.setText("");
            passwordField.setText("");
            layout.show(panels, "start");
        }

    }

}
