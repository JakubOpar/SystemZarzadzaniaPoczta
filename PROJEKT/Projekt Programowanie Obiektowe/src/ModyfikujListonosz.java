import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ModyfikujListonosz extends JFrame implements ILacz,IModyfikowanie {
    private JPanel ModyfikujListonoszPanel;
    private JButton anulujButton;
    private JButton zatwierdzButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private final int Width = 600, Height = 400;

    public ModyfikujListonosz(int index)
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.ModyfikujListonoszPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        this.setVisible(true);
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "SELECT `Imie_Listonosza`,`Nazwisko_Listonosza`,`ID_Rejonu` FROM `listonosze` WHERE ID_Listonosza = ? ";
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
                modyfikuj(index);
            }
        });
    }

    @Override
    public void modyfikuj(int id) {
        try {
            String ID_Rejonu = textField2.getText();
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "Select ID_Rejonu FROM rejon WHERE ID_rejonu = ?";
            PreparedStatement statement = lacz.prepareStatement(zapytanie);
            statement.setString(1,ID_Rejonu);
            int row = 0;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                row++;
            }

            if(row == 0)
            {
                JOptionPane.showMessageDialog(null,"Nie istnieje rejon o takim id!");
            }
            else
            {
                lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                String zapytanie2 = "UPDATE `listonosze` SET `Imie_Listonosza` = ?, `Nazwisko_Listonosza` = ?, `ID_Rejonu` = ? WHERE ID_Listonosza = ?";
                statement = lacz.prepareStatement(zapytanie2);
                statement.setString(1,textField1.getText());
                statement.setString(2,textField2.getText());
                statement.setString(3,textField3.getText());
                statement.setInt(4,id);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null,"Zaktualizowano dane!");
                }
            }
            lacz.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
