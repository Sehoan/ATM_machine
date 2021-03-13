import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {
    private Atm atm;
    private JPanel panels;
    private CardLayout layout;

    private JLabel headingLabel;
    private JButton depositButton, withdrawButton, transferButton, viewButton;
    private JButton cancelButton;

    public MenuPanel(Atm atm, JPanel panels, CardLayout layout) {
        this.atm = atm;
        this.layout = layout;
        this.panels = panels;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialization
        headingLabel = new JLabel("Choose Actions");
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");
        viewButton = new JButton("View");

        cancelButton = new JButton("LogIn with different account");
        depositButton.addActionListener(new depositListener());
        withdrawButton.addActionListener(new withdrawListener());
        transferButton.addActionListener(new transferListener());
        viewButton.addActionListener(new viewListener());

        cancelButton.addActionListener(new cancelListener());

        JPanel menus = new JPanel();
        menus.add(depositButton);
        menus.add(withdrawButton);
        menus.add(transferButton);
        menus.add(viewButton);

        add(headingLabel);
        add(menus);
        add(cancelButton);
    }

    private class depositListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            layout.show(panels, "deposit");
        }
    }

    private class withdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            layout.show(panels, "withdraw");
        }
    }

    private class transferListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            layout.show(panels, "transfer");
        }

    }

    private class viewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            layout.show(panels, "view");
        }

    }

    private class cancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            layout.show(panels, "start");
        }

    }

}
