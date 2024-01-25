import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ModyfikujRejon extends JFrame implements ILacz,IModyfikowanie {
    private JPanel ModyfikujRejonPanel;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField textField2;

    private final int Width = 600, Height = 400;

    public ModyfikujRejon(int index)
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.ModyfikujRejonPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        this.setVisible(true);
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "SELECT `Kod_Rejonu`,`Opis_Rejonu`,`ID_Oddzialu` FROM `rejon` WHERE `ID_Rejonu` = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setInt(1,index);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                textField1.setText(resultSet.getString(1));
                textArea1.setText(resultSet.getString(2));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                modyfikuj(index);
            }
        });
    }

    @Override
    public void modyfikuj(int id) {
        String idOddzialu = textField2.getText();
        try {
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "SELECT ID_Oddzialu FROM oddzialy WHERE ID_Oddzialu = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setString(1,idOddzialu);
            int row = 0;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                row++;
            }

            if(row == 0)
            {
                JOptionPane.showMessageDialog(null,"Nie istnieje odział o takim id!");
            }
            else
            {
                lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                String zapytanie2 = "UPDATE `rejon` SET `Kod_Rejonu` = ?, `Opis_Rejonu` = ?, `ID_Oddzialu` = ? WHERE ID_Rejonu = ?";
                statement = lacz.prepareStatement(zapytanie2);
                statement.setString(1,textField1.getText());
                statement.setString(2,textArea1.getText());
                statement.setString(3,textField2.getText());
                statement.setInt(4,id);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null,"Zaktualizowano dane!");
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
