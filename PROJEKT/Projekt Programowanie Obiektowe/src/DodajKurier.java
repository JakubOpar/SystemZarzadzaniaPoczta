import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajKurier extends JFrame{
    private JPanel DodajKurierPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton anulujButton;
    private JButton zatwierdzButton;

    private final int Width = 600, Height = 400;

    public DodajKurier()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.DodajKurierPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Kurier kurier = new Kurier(textField1.getText(),textField2.getText());
            kurier.Dodaj();
            dispose();
            }
        });
    }
}
