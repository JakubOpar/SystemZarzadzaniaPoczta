import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajRejon extends JFrame {
    private JPanel DodajRejonPanel;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField textField1;
    private JTextArea textArea1;

    private final int Width = 600, Height = 400;

    public DodajRejon()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.DodajRejonPanel);
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
                String kodRejonu = textField1.getText();
                String opisRejonu = textArea1.getText();
                if(kodRejonu.matches("^[1-9]{5}$") && opisRejonu.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,200}$"))
                {
                    Rejon rejon = new Rejon(Integer.parseInt(kodRejonu),opisRejonu);
                    try {
                        rejon.Dodaj();
                    } catch (QueryException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Zły format danych \n" +
                            "kod rejonu może zawierać tylko cyfry i musi mieć długość 5 znaków \n" +
                            "oraz opis rejonu ma maksymalną długgość 200 znaków!");
                }

            }
        });
    }
}
