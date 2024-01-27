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

                if(nazwaOddzialu.matches("^[a-zA-Z0-9ęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,50}$") && adresZameldowania.matches("^[a-zA-Z0-9ęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,50}$")
                && kodPocztowy.matches("^[0-9]{2}-[0-9]{3}$") && miejscowosc.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,20}$"))
                {
                    Oddzial oddzial = new Oddzial(nazwaOddzialu,adresZameldowania,kodPocztowy,miejscowosc);
                    try {
                        oddzial.Dodaj();
                    } catch (QueryException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Podano zły format danych");
                }

            }
        });
    }
}
