import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ZarzadzajListonosz extends JFrame implements ILacz,IWyswietlanie {
    private JPanel ZarzadzajListonoszPanel;
    private JButton dodajButton;
    private JButton zAButton;
    private JButton usunButton;
    private JButton aZButton;
    private JButton modyfikujButton;
    private JTextField textField1;
    private JButton wyszukajButton;
    private JButton odswiezButton;
    private JButton wyczyscFiltryButton;
    private JTable table1;
    private JButton wyjscieButton;

    private final int Width = 1000, Height = 600;

    public ZarzadzajListonosz()
    {
        super("System zarządzania pocztą");
        this.setContentPane(this.ZarzadzajListonoszPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        createTable();
        try {
            wyswietl();
        } catch (QueryException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WyborPracownik wyborPracownik = new WyborPracownik();
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajListonosz dodajListonosz = new DodajListonosz();
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsunListonosz usunListonosz = new UsunListonosz();
            }
        });
        modyfikujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tblModel = (DefaultTableModel) table1.getModel();
                if(table1.getSelectedRowCount()==1)
                {
                    int selectedRow = table1.getSelectedRow();
                    Object Id = table1.getValueAt(selectedRow,0);
                    ModyfikujListonosz modyfikujListonosz = new ModyfikujListonosz(Integer.parseInt(Id.toString()));
                }
                else {
                    if (table1.getRowCount() == 0)
                        JOptionPane.showMessageDialog(null,"Brak danych!");
                    else
                        JOptionPane.showMessageDialog(null,"Proszę zaznaczyć tylko jeden wiersz!");
                }
            }
        });
        aZButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                Connection lacz = null;
                try {
                    lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                    String zapytanie = "SELECT * FROM `listonosze` ORDER BY `Nazwisko_Listonosza` ASC";
                    Statement statement = lacz.createStatement();
                    ResultSet resultSet = statement.executeQuery(zapytanie);
                    while (resultSet.next())
                    {
                        int idListonosza = resultSet.getInt(1);
                        String imieListonosza = resultSet.getString(2);
                        String nazwiskoListonosza = resultSet.getString(3);
                        int idRejonu = resultSet.getInt(4);

                        String tempIdRejonu = Integer.toString(idRejonu);
                        if(tempIdRejonu.equals("0"))
                        {
                            tempIdRejonu = "Nie przydzielono";
                        }
                        String[] data = {
                                Integer.toString(idListonosza),
                                imieListonosza,
                                nazwiskoListonosza,
                                tempIdRejonu
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }
                    lacz.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Wystąpił błąd w zapytaniu Sql");
                }
            }
        });
        zAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                Connection lacz = null;
                try {
                    lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                    String zapytanie = "SELECT * FROM `listonosze` ORDER BY `Nazwisko_Listonosza` DESC";
                    Statement statement = lacz.createStatement();
                    ResultSet resultSet = statement.executeQuery(zapytanie);
                    while (resultSet.next())
                    {
                        int idListonosza = resultSet.getInt(1);
                        String imieListonosza = resultSet.getString(2);
                        String nazwiskoListonosza = resultSet.getString(3);
                        int idRejonu = resultSet.getInt(4);

                        String tempIdRejonu = Integer.toString(idRejonu);
                        if(tempIdRejonu.equals("0"))
                        {
                            tempIdRejonu = "Nie przydzielono";
                        }
                        String[] data = {
                                Integer.toString(idListonosza),
                                imieListonosza,
                                nazwiskoListonosza,
                                tempIdRejonu
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }
                    lacz.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Wystąpił błąd w zapytaniu Sql");
                }
            }
        });
        wyszukajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                String value = textField1.getText();
                textField1.setText("");
                Connection lacz = null;
                try {
                    lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
                    String zapytanie = "SELECT * FROM `listonosze` WHERE `ID_Listonosza`=? OR `Imie_Listonosza`=? OR `Nazwisko_Listonosza`=?";
                    PreparedStatement statement = lacz.prepareStatement(zapytanie);
                    statement.setString(1,value);
                    statement.setString(2,value);
                    statement.setString(3,value);

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next())
                    {
                        int idListonosza = resultSet.getInt(1);
                        String imieListonosza = resultSet.getString(2);
                        String nazwiskoListonosza = resultSet.getString(3);
                        int idRejonu = resultSet.getInt(4);

                        String tempIdRejonu = Integer.toString(idRejonu);
                        if(tempIdRejonu.equals("0"))
                        {
                            tempIdRejonu = "Nie przydzielono";
                        }
                        String[] data = {
                                Integer.toString(idListonosza),
                                imieListonosza,
                                nazwiskoListonosza,
                                tempIdRejonu
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }
                    lacz.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Wystąpił błąd w zapytaniu Sql");
                }
            }
        });
        odswiezButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                try {
                    wyswietl();
                } catch (QueryException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        wyczyscFiltryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                try {
                    wyswietl();
                } catch (QueryException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    @Override
    public void wyswietl() throws QueryException {
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            Statement statement = lacz.createStatement();
            String zapytanie2 = "SELECT * FROM listonosze";
            ResultSet resultSet = statement.executeQuery(zapytanie2);
            while (resultSet.next())
            {
                int idListonosza = resultSet.getInt(1);
                String imieListonosza = resultSet.getString(2);
                String nazwiskoListonosza = resultSet.getString(3);
                int idRejonu = resultSet.getInt(4);

                String tempIdRejonu = Integer.toString(idRejonu);
                if(tempIdRejonu.equals("0"))
                {
                    tempIdRejonu = "Nie przydzielono";
                }
                String[] data = {
                        Integer.toString(idListonosza),
                        imieListonosza,
                        nazwiskoListonosza,
                        tempIdRejonu
                };

                DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                tableModel.addRow(data);
            }
            lacz.close();
        }
        catch(SQLException e)
        {
            throw new QueryException("Wystąpił błąd w zapytaniu Sql");
        }
    }

    @Override
    public void createTable() {
        Object[][] data = {};
        table1.setModel(new DefaultTableModel(
                data,new String[]{"ID_Listonosza","Imie","Nazwisko (S)","Id_Rejonu"}
        ));

        TableColumnModel column = table1.getColumnModel();
        DefaultTableCellRenderer centerRendered = new DefaultTableCellRenderer();
        centerRendered.setHorizontalAlignment(JLabel.CENTER);
        column.getColumn(0).setCellRenderer(centerRendered);
        column.getColumn(1).setCellRenderer(centerRendered);
        column.getColumn(2).setCellRenderer(centerRendered);
        column.getColumn(3).setCellRenderer(centerRendered);
    }
}
