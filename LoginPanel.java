import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
    private Atm atm;
    private JPanel panels;
    private CardLayout layout;

    private JLabel headingLabel;
    private JLabel account, password;
    private JTextField accountField, passwordField;
    private JLabel statusLabel;
    private JButton loginButton, cancelButton;

    public LoginPanel(Atm atm, JPanel panels, CardLayout layout) {
        this.atm = atm;
        this.layout = layout;
        this.panels = panels;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialization
        headingLabel = new JLabel("Log In");
        account = new JLabel("AccountHolder");
        password = new JLabel("Password");
        accountField = new JTextField(20);
        passwordField = new JTextField(20);
        statusLabel = new JLabel("");
        loginButton = new JButton("Log In");
        cancelButton = new JButton("Cancel");


        JPanel accountPanel = new JPanel();
        accountPanel.add(account);
        accountPanel.add(accountField);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(password);
        passwordPanel.add(passwordField);

        loginButton.addActionListener(new logIn());
        cancelButton.addActionListener(new cancelListener());

        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        accountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headingLabel);
        add(accountPanel);
        add(passwordPanel);
        add(statusLabel);
        add(loginButton);
        add(cancelButton);
    }

    private class logIn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            boolean success = atm.loginToAccount(accountField.getText(),passwordField.getText());
            if(success) {
                layout.show(panels, "menu");
            }else {
                statusLabel.setText("wrong username or password!");
            }
            accountField.setText("");
            passwordField.setText("");
        }

    }

    private class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            accountField.setText("");
            passwordField.setText("");
            statusLabel.setText("");
            layout.show(panels, "start");
        }

    }
}
