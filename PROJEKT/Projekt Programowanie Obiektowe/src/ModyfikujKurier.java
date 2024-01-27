import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ModyfikujKurier extends JFrame implements ILacz,IModyfikowanie {
    private JPanel ModyfikujKurierPanel;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private final int Width = 600, Height = 400;

    public ModyfikujKurier(int index)
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.ModyfikujKurierPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        this.setVisible(true);
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "SELECT `Imie_Kuriera`,`Nazwisko_Kuriera`,`ID_Rejonu` FROM `kurierzy` WHERE ID_Kuriera = ? ";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setInt(1,index);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                textField1.setText(resultSet.getString(1));
                textField2.setText(resultSet.getString(2));
                textField3.setText(resultSet.getString(3));
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
                try {
                    modyfikuj(index);
                } catch (QueryException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    @Override
    public void modyfikuj(int id) throws QueryException {
        String imieKuriera = textField1.getText();
        String nazwiskoKuriera = textField2.getText();
        String idRejonu = textField3.getText();
        int row = 0;
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "Select ID_Rejonu FROM rejon WHERE ID_rejonu = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setString(1,idRejonu);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                row++;
            }
            lacz.close();
        }catch (SQLException e)
        {
            throw new QueryException("Wystąpił bład w zapytaniu Sql");
        }

        if(imieKuriera.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$") && nazwiskoKuriera.matches("^[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]{1,20}$") && idRejonu.matches("^[0-9]{1,3}$") && row > 0)
        {
            try {
                Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                String zapytanie = "UPDATE `kurierzy` SET `Imie_Kuriera` = ?, `Nazwisko_Kuriera` = ?, `ID_Rejonu` = ? WHERE ID_kuriera = ?";
                PreparedStatement statement = lacz.prepareStatement(zapytanie);
                statement.setString(1,imieKuriera);
                statement.setString(2,nazwiskoKuriera);
                statement.setString(3,idRejonu);
                statement.setInt(4,id);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null,"Zaktualizowano dane!");
                }
                lacz.close();
            } catch (SQLException e) {
                throw new QueryException("Wystąpił bład w zapytaniu Sql");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, " Zły format danych lub brak rejonu o takim id\n" +
                    "Notka: Pole może zawierać tylko litery i mieć maksymalną długość 20 znaków\n");
        }
    }
}
