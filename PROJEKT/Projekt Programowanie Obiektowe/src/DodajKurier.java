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
                String imieKuriera = textField1.getText();
                String nazwiskoKuriera = textField2.getText();
                if(imieKuriera.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$") && nazwiskoKuriera.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                {
                    Kurier kurier = new Kurier(imieKuriera,nazwiskoKuriera);
                    try {
                        kurier.Dodaj();
                    } catch (QueryException ex) {
                      JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, """
                            Zły format danych\s
                             Pole może zawierać tylko litery i mieć
                             maksymalną długość 20 znaków!""");
                }
            }
        });
    }
}
