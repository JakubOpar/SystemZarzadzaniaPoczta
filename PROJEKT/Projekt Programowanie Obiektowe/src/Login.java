import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel LogPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton exitButton;

    private final int Width = 600, Height = 400;
    private String Log = "Admin", Pass = "Admin";
    public Login()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.LogPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        this.setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Login = textField1.getText();
                String Password = new String(passwordField1.getPassword());
              if(!Login.equals(Log) || !Password.equals(Pass))
                {
                    JOptionPane.showMessageDialog(null,"Nie prawidłowe dane logowania");
                }
                else
                {
                    dispose();
                    Menu menuWindow = new Menu();
                }
            }
        });
    }
}
