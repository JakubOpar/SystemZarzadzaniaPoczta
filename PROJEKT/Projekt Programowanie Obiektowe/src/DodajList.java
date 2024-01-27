import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajList extends JFrame {
    private JPanel DodajListonoszPanel;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField textFieldN1;
    private JTextField textFieldN5;
    private JTextField textFieldN4;
    private JTextField textFieldN3;
    private JTextField textFieldN2;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JTextField textFieldO1;
    private JTextField textFieldO5;
    private JTextField textFieldO4;
    private JTextField textFieldO3;
    private JTextField textFieldO2;

    private final int Width = 1000, Height = 550;

    public DodajList()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.DodajListonoszPanel);
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
                int czyPolecony;
                if(checkBox1.isSelected())
                {
                    czyPolecony = 1;
                }
                else
                {
                    czyPolecony = 0;
                }

                int czyZPotwierdzeniemOdbioru;
                if(checkBox2.isSelected())
                {
                    czyZPotwierdzeniemOdbioru = 1;
                }
                else
                {
                    czyZPotwierdzeniemOdbioru = 0;
                }

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

                String komunikat = "Zły format danych w Polach: \n";
                int blad = 0;

                    if(!imieNadawcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                    {
                        komunikat += "imie nadawcy (Max. 20 znaków) \n";
                        blad++;
                    }
                    if(!nazwiskoNadawcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                    {
                        komunikat += "nazwisko nadawcy (Max. 20 znaków) \n";
                        blad++;
                    }
                    if(!adresNadawcy.matches("^[a-zA-Z0-9ęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,30}$"))
                    {
                        komunikat += "adres nadawcy (Max. 30 znaków) \n";
                        blad++;
                    }
                    if(!kodPocztowyNadawcy.matches("^[0-9]{2}-[0-9]{3}$"))
                    {
                        komunikat += "kod pocztowy nadawcy (prawidłowy Format XX-XXX) \n";
                        blad++;
                    }
                    if(!miejscowoscNadawcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,20}$"))
                    {
                        komunikat += "miejscowosc kp. nadawcy (Max. 20 znaków)\n";
                        blad++;
                    }
                    if(!imieOdbiorcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                    {
                        komunikat += "imie odbiorcy (Max. 20 znaków) \n";
                        blad++;
                    }
                    if(!nazwiskoOdbiorcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                    {
                        komunikat += "nazwisko odbiorcy (Max. 20 znaków) \n";
                        blad++;
                    }
                    if(!adresObdiorcy.matches("^[a-zA-Z0-9ęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,30}$"))
                    {
                        komunikat += "adres odbiorcy (Max. 30 znaków) \n";
                        blad++;
                    }
                    if(!kodPocztowyOdbiorcy.matches("^[0-9]{2}-[0-9]{3}$"))
                    {
                        komunikat += "kod pocztowy odbiorcy (prawidłowy Format XX-XXX) \n";
                        blad++;
                    }
                    if(!miejscowoscOdbiorcy.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]{1,30}$"))
                    {
                        komunikat += "miejscowosc kp. odbiorcy (Max. 20 znaków)  \n";
                        blad++;
                    }

                   if(blad > 0)
                    {
                        JOptionPane.showMessageDialog(null,komunikat);
                    }
                    else
                    {
                        List list = new List(imieNadawcy,nazwiskoNadawcy,adresNadawcy,kodPocztowyNadawcy,miejscowoscNadawcy,
                                imieOdbiorcy,nazwiskoOdbiorcy,adresObdiorcy,kodPocztowyOdbiorcy,miejscowoscOdbiorcy,czyPolecony,czyZPotwierdzeniemOdbioru);
                        try {
                            list.Dodaj();
                        } catch (QueryException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                        dispose();
                    }

            }
        });
    }
}
