import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyborPrzesylka extends JFrame {
    private JPanel WyborPrzesPanel;
    private JButton listButton;
    private JButton paczkaButton;
    private JButton wyjscieButton;
    private final int Width = 600, Height = 400;

    public WyborPrzesylka()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.WyborPrzesPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZarzadzajListami zarzadzajListami = new ZarzadzajListami();
            }
        });
        paczkaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZarzadzajPaczkami zarzadzajPaczkami = new ZarzadzajPaczkami();
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


