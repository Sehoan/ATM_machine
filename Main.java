import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Atm atm = new Atm();

        JFrame frame = new JFrame("ATM Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 180));

        JPanel panels = new JPanel(new CardLayout());
        CardLayout cl = (CardLayout) panels.getLayout();

        // create each panel
        StartPanel startPanel = new StartPanel(panels,cl);
        CreatePanel createPanel = new CreatePanel(atm,panels,cl);
        LoginPanel loginPanel = new LoginPanel(atm,panels,cl);
        MenuPanel menuPanel = new MenuPanel(atm,panels,cl);

        DepositPanel depositPanel = new DepositPanel(atm,panels,cl);
        WithdrawPanel withdrawPanel = new WithdrawPanel(atm,panels,cl);
        TransferPanel transferPanel = new TransferPanel(atm,panels,cl);
        ViewPanel viewPanel = new ViewPanel(atm,panels,cl);
        //MenuPanel menuPanel = new MenuPanel(atm,panels,cl);

        // add each panel to the stack of panels
        panels.add(startPanel, "start");
        panels.add(createPanel, "create");
        panels.add(loginPanel, "login");
        panels.add(menuPanel, "menu");
        panels.add(depositPanel, "deposit");
        panels.add(withdrawPanel, "withdraw");
        panels.add(transferPanel, "transfer");
        panels.add(viewPanel, "view");

        cl.show(panels, "start");

        frame.getContentPane().add(panels);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
