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
                textField2.setText(resultSet.getString(3));
            }
            lacz.close();
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
            String idOddzialu = textField2.getText();
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "SELECT ID_Oddzialu FROM oddzialy WHERE ID_Oddzialu = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setInt(1,Integer.parseInt(idOddzialu));
            int row = 0;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                row++;
            }

            String kodRejonu = textField1.getText();
            String opisRejonu = textArea1.getText();
            if(kodRejonu.matches("^[1-9]{5}$") && opisRejonu.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,200}$") && idOddzialu.matches("^[0-9]{1,3}$") && row > 0)
            {
                int idOddzial = Integer.parseInt(idOddzialu);
                lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                String zapytanie2 = "UPDATE `rejon` SET `Kod_Rejonu` = ?, `Opis_Rejonu` = ?, `ID_Oddzialu` = ? WHERE ID_Rejonu = ?";
                statement = lacz.prepareStatement(zapytanie2);
                statement.setString(1,kodRejonu);
                statement.setString(2,opisRejonu);
                statement.setInt(3, idOddzial);
                statement.setInt(4,id);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null,"Zaktualizowano dane!");
                }
                lacz.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Zły format danych \n" +
                        "kod rejonu może zawierać tylko cyfry i musi mieć długość 5 znaków \n" +
                        "oraz opis rejonu ma maksymalną długgość 200 znaków!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
