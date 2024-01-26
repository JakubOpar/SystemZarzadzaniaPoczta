import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ModyfikujList extends JFrame implements ILacz,IModyfikowanie{
    private JPanel ModyfikujListPanel;
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
    private JTextField textField1;
    private JTextField textField2;

    private final int Width = 1000, Height = 400;

    public ModyfikujList(int index)
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.ModyfikujListPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        this.setVisible(true);
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "SELECT `Imie_Nadawcy`,`Nazwisko_Nadawcy`,`Adres_Nadawcy`,`Kod_Pocztowy_Nadawcy`,`Kod_Pocztowy_Miejscowosc_Nadawcy`," +
                    "`Imie_Odbiorcy`,`Nazwisko_Odbiorcy`,`Adres_Odbiorcy`,`Kod_Pocztowy_Odbiorcy`,`Kod_Pocztowy_Miejscowosc_Odbiorcy`," +
                    "`ID_Listonosza`,`Status` FROM `listy` WHERE `ID_Listu`= ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setInt(1,index);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                textFieldN1.setText(resultSet.getString(1));
                textFieldN2.setText(resultSet.getString(2));
                textFieldN3.setText(resultSet.getString(3));
                textFieldN4.setText(resultSet.getString(4));
                textFieldN5.setText(resultSet.getString(5));
                textFieldO1.setText(resultSet.getString(6));
                textFieldO2.setText(resultSet.getString(7));
                textFieldO3.setText(resultSet.getString(8));
                textFieldO4.setText(resultSet.getString(9));
                textFieldO5.setText(resultSet.getString(10));
                textField2.setText(resultSet.getString(11));
                textField1.setText(resultSet.getString(12));

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
        try {
            String ID_Listonosza = textField2.getText();
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "Select ID_Listonosza FROM listonosze WHERE ID_Listonosza = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setString(1,ID_Listonosza);
            int row = 0;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                row++;
            }

            String status = textField1.getText();

            if(row == 0 || !status.equals("Oczekuje do wysłania") && !status.equals("Wysłano") && !status.equals("Dostarczono"))
            {
                JOptionPane.showMessageDialog(null,"Nie istnieje listonosz o takim id\n lub \n podano nieprawidłowy status");
            }
            else
            {
                lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                String zapytanie2 = "UPDATE `listy` SET `Imie_Nadawcy`= ?,`Nazwisko_Nadawcy`= ?,`Adres_Nadawcy`= ?," +
                        "`Kod_Pocztowy_Nadawcy`= ?,`Kod_Pocztowy_Miejscowosc_Nadawcy`= ?," +
                        "`Imie_Odbiorcy`= ?,`Nazwisko_Odbiorcy`= ?,`Adres_Odbiorcy`= ?,`Kod_Pocztowy_Odbiorcy`=?," +
                        "`Kod_Pocztowy_Miejscowosc_Odbiorcy`= ?,`ID_Listonosza`= ? ,`Status`= ? " +
                        "WHERE ID_Listu = ?";
                statement = lacz.prepareStatement(zapytanie2);
                statement.setString(1,textFieldN1.getText());
                statement.setString(2,textFieldN2.getText());
                statement.setString(3,textFieldN3.getText());
                statement.setString(4,textFieldN4.getText());
                statement.setString(5,textFieldN5.getText());
                statement.setString(6,textFieldO1.getText());
                statement.setString(7,textFieldO2.getText());
                statement.setString(8,textFieldO3.getText());
                statement.setString(9,textFieldO4.getText());
                statement.setString(10,textFieldO5.getText());
                statement.setInt(11,Integer.parseInt(textField2.getText()));
                statement.setString(12,status);
                statement.setInt(13,id);

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
