import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ModyfikujOddzial extends JFrame implements ILacz,IModyfikowanie {
    private JPanel ModyfikujOddzialPanel;
    private JButton wyjscieButton;
    private JButton zatwierdzButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private final int Width = 600, Height = 400;

    public ModyfikujOddzial(int index)
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.ModyfikujOddzialPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        this.setVisible(true);
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "SELECT `Nazwa_Oddzialu`,`Miejsce_Zameldowania`,`Kod_Pocztowy`,`Miejscowosc` FROM `oddzialy` WHERE ID_Oddzialu = ? ";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setInt(1,index);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                textField1.setText(resultSet.getString(1));
                textField2.setText(resultSet.getString(2));
                textField3.setText(resultSet.getString(3));
                textField4.setText(resultSet.getString(4));
            }


        }catch(SQLException e)
        {
            e.printStackTrace();
        }

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
                modyfikuj(index);
            }
        });
    }

    @Override
    public void modyfikuj(int id) {
        try {
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "UPDATE `oddzialy` SET `Nazwa_Oddzialu` = ?, `Miejsce_Zameldowania` = ?, `Kod_Pocztowy` = ?, `Miejscowosc` = ? WHERE `oddzialy`.`ID_Oddzialu` = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setString(1,textField1.getText());
            statement.setString(2,textField2.getText());
            statement.setString(3,textField3.getText());
            statement.setString(4,textField4.getText());
            statement.setInt(5,id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null,"Zaktualizowano dane!");
            }
            lacz.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
