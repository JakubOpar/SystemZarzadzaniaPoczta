import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsunOddzial extends JFrame implements ILacz,IUsuwanie {
    private JPanel usunOddzialPanel;
    private JTextField textField1;
    private JButton wyjscieButton;
    private JButton zatwierdzButton;

    private final int Width = 300, Height = 200;

    public UsunOddzial()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.usunOddzialPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            usun(textField1.getText());
            }
        });
    }

    @Override
    public void usun(String arg) {
        try {
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie ="DELETE FROM oddzialy WHERE oddzialy.ID_Oddzialu = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setString(1,arg);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null,"Oddział został usunięty pomyślnie");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
