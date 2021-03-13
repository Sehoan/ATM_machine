import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewPanel extends JPanel {
    private Atm atm;
    private JPanel panels;
    private CardLayout layout;

    private JLabel headingLabel;
    private JLabel summaryLabel;

    private JButton viewButton, backButton;

    public ViewPanel(Atm atm, JPanel panels, CardLayout layout) {
        this.atm = atm;
        this.layout = layout;
        this.panels = panels;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // initialization
        headingLabel = new JLabel("Summary of Your Account");
        summaryLabel = new JLabel("");

        viewButton = new JButton("Click to View Summary");
        viewButton.addActionListener(new viewListener());
        backButton = new JButton("back");
        backButton.addActionListener(new backListener());

        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        summaryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headingLabel);
        add(summaryLabel);
        add(viewButton);
        add(backButton);
    }

    private class viewListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            BankAccount loggedAccount = atm.getLoggedAccount();
            String summary = "<html>" + "Account Holder: " + loggedAccount.getHolder() + "<br>Account Number: "
                    + loggedAccount.getNumber() + "<br>Password: " + loggedAccount.getPassword() + "<br>Balance: "
                    + loggedAccount.getBalance() + "</html>";

            summaryLabel.setText(summary);
        }
    }

    private class backListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            summaryLabel.setText("");
            layout.show(panels, "menu");
        }
    }

}
