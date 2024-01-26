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
                Paczka paczka = new Paczka(textFieldN1.getText(),textFieldN2.getText(),textFieldN3.getText(),textFieldN4.getText(),textFieldN5.getText(),
                        textFieldO1.getText(),textFieldO2.getText(),textFieldO3.getText(),textFieldO4.getText(),textFieldO5.getText(),czyDelikatna,
                        Double.parseDouble(textField1.getText()));
                paczka.Dodaj();
                dispose();
            }
        });
    }
}
