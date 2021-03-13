import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartPanel extends JPanel {
    private JPanel panels;
    private CardLayout layout;
    private JLabel headingLabel;
    private JButton createButton, loginButton;

    public StartPanel(JPanel panels, CardLayout layout) {
        this.layout = layout;
        this.panels = panels;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        headingLabel = new JLabel("Welcome to ATM");
        createButton = new JButton("Create a New Bank Account");
        loginButton = new JButton("Login to Existing Bank Account");

        createButton.addActionListener(new createListener());
        loginButton.addActionListener(new loginListener());

        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headingLabel);
        add(createButton);
        add(loginButton);
    }

    private class createListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            layout.show(panels, "create");
        }

    }

    private class loginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            layout.show(panels, "login");
        }

    }
}
