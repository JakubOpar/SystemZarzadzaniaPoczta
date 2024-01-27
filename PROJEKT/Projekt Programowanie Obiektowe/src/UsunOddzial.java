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
    private JButton anulujButton;
    private JButton zatwierdzButton;

    private final int Width = 300, Height = 200;

    public UsunOddzial()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.usunOddzialPanel);
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
                String arg = textField1.getText();
                if(arg.matches("^[1-9]{1,3}$"))
                {
                    try {
                        usun(arg);
                    } catch (QueryException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wartość musi być cyfrą!");
                }
            }
        });
    }

    @Override
    public void usun(String arg) throws QueryException {
        try {
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie ="DELETE FROM oddzialy WHERE oddzialy.ID_Oddzialu = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setString(1,arg);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null,"Oddział został usunięty pomyślnie");
            }
            lacz.close();
        } catch (SQLException e) {
            throw new QueryException("Wystąpił błąd w zapytaniu Sql");
        }
    }
}
