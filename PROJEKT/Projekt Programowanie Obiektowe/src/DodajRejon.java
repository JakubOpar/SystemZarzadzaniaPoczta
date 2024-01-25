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
                int numerRejonu = Integer.parseInt(textField1.getText());
                String opisRejonu = textArea1.getText();

                Rejon rejon = new Rejon(numerRejonu,opisRejonu);
                rejon.Dodaj();
                dispose();
            }
        });
    }
}
