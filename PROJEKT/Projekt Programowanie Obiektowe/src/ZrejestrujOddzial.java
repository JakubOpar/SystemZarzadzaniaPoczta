import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZrejestrujOddzial extends JFrame {
    private JPanel ZarejestrujOddzialPanel;
    private JButton zatwierdzButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton anulujButton;

    private final int Width = 600, Height = 400;
    public ZrejestrujOddzial()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.ZarejestrujOddzialPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        this.setVisible(true);
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwaOddzialu = textField1.getText();
                String adresZameldowania = textField2.getText();
                String kodPocztowy = textField3.getText();
                String miejscowosc = textField4.getText();

                Oddzial oddzial = new Oddzial(nazwaOddzialu,adresZameldowania,kodPocztowy,miejscowosc);
                oddzial.Dodaj();
                dispose();
            }
        });
    }
}
