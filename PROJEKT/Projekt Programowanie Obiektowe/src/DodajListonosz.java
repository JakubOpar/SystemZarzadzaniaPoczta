import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajListonosz extends JFrame {
    private JPanel DodajListonoszPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton anulujButton;
    private JButton zatwierdzButton;

    private final int Width = 600, Height = 400;

    public DodajListonosz()
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
                String imieListonosza = textField1.getText();
                String nazwiskoListonosza = textField2.getText();
                if(imieListonosza.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$") && nazwiskoListonosza.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$"))
                {
                    Listonosz listonosz = new Listonosz(textField1.getText(),textField2.getText());
                    listonosz.Dodaj();
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
