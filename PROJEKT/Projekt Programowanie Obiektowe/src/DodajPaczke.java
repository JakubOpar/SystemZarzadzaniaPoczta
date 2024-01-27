import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajPaczke extends JFrame {
    private JPanel DodajPaczkePanel;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField textFieldN1;
    private JTextField textFieldN5;
    private JTextField textFieldN4;
    private JTextField textFieldN3;
    private JTextField textFieldN2;
    private JCheckBox checkBox1;
    private JTextField textFieldO1;
    private JTextField textFieldO5;
    private JTextField textFieldO4;
    private JTextField textFieldO3;
    private JTextField textFieldO2;
    private JTextField textField1;

    private final int Width = 1000, Height = 400;

    public DodajPaczke()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.DodajPaczkePanel);
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
                int czyDelikatna;
                if(checkBox1.isSelected())
                {
                    czyDelikatna = 1;
                }
                else
                {
                    czyDelikatna = 0;
                }

                String komunikat = "Niepoprawny format danych \n";
                int blad = 0;

                String imieNadawcy = textFieldN1.getText();
                String nazwiskoNadawcy = textFieldN2.getText();
                String adresNadawcy = textFieldN3.getText();
                String kodPocztowyNadawcy = textFieldN4.getText();
                String miejscowoscNadawcy = textFieldN5.getText();
                String imieOdbiorcy = textFieldO1.getText();
                String nazwiskoOdbiorcy = textFieldO2.getText();
                String adresObdiorcy = textFieldO3.getText();
                String kodPocztowyOdbiorcy = textFieldO4.getText();
                String miejscowoscOdbiorcy = textFieldO5.getText();
                String waga = textField1.getText();


                if(!imieNadawcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                {
                    komunikat += "imie nadawcy \n";
                    blad++;
                }
                if(!nazwiskoNadawcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                {
                    komunikat += "nazwisko nadawcy \n";
                    blad++;
                }
                if(!adresNadawcy.matches("^[a-zA-Z0-9ęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,30}$"))
                {
                    komunikat += "adres nadawcy \n";
                    blad++;
                }
                if(!kodPocztowyNadawcy.matches("^[0-9]{2}-[0-9]{3}$"))
                {
                    komunikat += "kod pocztowy nadawcy \n";
                    blad++;
                }
                if(!miejscowoscNadawcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,20}$"))
                {
                    komunikat += "miejscowosc kp. nadawcy \n";
                    blad++;
                }
                if(!imieOdbiorcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                {
                    komunikat += "imie odbiorcy \n";
                    blad++;
                }
                if(!nazwiskoOdbiorcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                {
                    komunikat += "nazwisko odbiorcy \n";
                    blad++;
                }
                if(!adresObdiorcy.matches("^[a-zA-Z0-9ęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,30}$"))
                {
                    komunikat += "adres odbiorcy \n";
                    blad++;
                }
                if(!kodPocztowyOdbiorcy.matches("^[0-9]{2}-[0-9]{3}$"))
                {
                    komunikat += "kod pocztowy odbiorcy \n";
                    blad++;
                }
                if(!miejscowoscOdbiorcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,30}$"))
                {
                    komunikat += "miejscowosc kp. odbiorcy \n";
                    blad++;
                }
                if(!waga.matches("^\\d+(\\.\\d{1,2})?$"))
                {
                    komunikat += "waga \n";
                    blad++;
                }


                if(blad > 0)
                {
                    JOptionPane.showMessageDialog(null,komunikat);
                }
                else
                {
                    Paczka paczka = new Paczka(imieNadawcy,nazwiskoNadawcy,adresNadawcy,kodPocztowyNadawcy,miejscowoscNadawcy,
                            imieOdbiorcy,nazwiskoOdbiorcy,adresObdiorcy,kodPocztowyOdbiorcy,miejscowoscOdbiorcy,
                            czyDelikatna,Double.parseDouble(waga));
                    paczka.Dodaj();
                    dispose();
                }

            }
        });
    }
}
