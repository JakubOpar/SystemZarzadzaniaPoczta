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
        super("Post Menagment System");
        this.setContentPane(this.WyborPrzesPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        paczkaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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


