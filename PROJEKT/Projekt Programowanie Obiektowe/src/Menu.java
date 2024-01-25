import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel MenuPanel;
    private JButton wyjscieButton;
    private JButton odzialyButton;
    private JButton rejonyButton;
    private JButton pracownicyButton;
    private JButton przesylkiButton;

    private final int Width = 600, Height = 500;

    public Menu()
    {
        super("Post Menagment System");
        this.setContentPane(this.MenuPanel);
        this.setSize(Width,Height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
            }
        });
        odzialyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZarzadzajOddzialami zarzadzajOddzialami = new ZarzadzajOddzialami();
            }
        });
        rejonyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZarzadzajRejonami zarzadzajRejonami = new ZarzadzajRejonami();

            }
        });
        pracownicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WyborPracownik wyborPracownik = new WyborPracownik();
            }
        });
        przesylkiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
