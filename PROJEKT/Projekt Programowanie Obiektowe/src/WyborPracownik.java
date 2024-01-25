import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyborPracownik extends JFrame {
    private JPanel wPracPanel;
    private JButton listonoszButton;
    private JButton kurierButton;
    private JButton wyjscieButton;

    private final int Width = 600, Height = 400;

    public WyborPracownik()
    {
        super("Post Menagment System");
        this.setContentPane(this.wPracPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(Width,Height);
        listonoszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZarzadzajListonosz zarzadzajListonosz = new ZarzadzajListonosz();
            }
        });
        kurierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZarzadzajKurier zarzadzajKurier = new ZarzadzajKurier();
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menuWindow = new Menu();
            }
        });
    }
}
