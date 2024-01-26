import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ZarzadzajOddzialami extends JFrame implements ILacz,IWyswietlanie {
    private JPanel ZarzadzajOddzialamiPanel;
    private JButton dodajButton;
    private JButton zAButton;
    private JButton usunButton;
    private JButton modyfikujButton;
    private JButton wyszukajButton;
    private JButton aZButton;
    private JTable table1;
    private JButton wyjscieButton;
    private JButton wyczyscFiltryButton;
    private JButton odswiezButton;
    private JTextField textField1;

    private final int Width = 1000, Height = 600;

    public ZarzadzajOddzialami()
    {
        super("Post Menagment System");
        this.setContentPane(this.ZarzadzajOddzialamiPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        createTable();
        wyswietl();

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu();
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZrejestrujOddzial zrejestrujOddzial = new ZrejestrujOddzial();
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsunOddzial usunOddzial = new UsunOddzial();
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
                   ModyfikujOddzial modyfikujOddzial = new ModyfikujOddzial(Integer.parseInt(Id.toString()));
                }
                else {
                    if (table1.getRowCount() == 0)
                        JOptionPane.showMessageDialog(null,"Brak danych!");
                    else
                        JOptionPane.showMessageDialog(null,"Proszę zaznaczyć tylko jeden wiersz!");
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
                    String zapytanie = "SELECT * FROM `oddzialy` WHERE `ID_Oddzialu`=? OR `Nazwa_Oddzialu` LIKE ? OR `Miejsce_Zameldowania` LIKE ? OR `Kod_Pocztowy` LIKE ? OR `Miejscowosc` LIKE ?";
                    PreparedStatement statement = lacz.prepareStatement(zapytanie);
                    statement.setString(1,value);
                    statement.setString(2,value);
                    statement.setString(3,value);
                    statement.setString(4,value);
                    statement.setString(5,value);


                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next())
                    {
                        int idOddzialu = resultSet.getInt(1);
                        String nazwaOddzialu = resultSet.getString(2);
                        String miejsceZameldowania = resultSet.getString(3);
                        String kodPocztowy = resultSet.getString(4);
                        String miejscowosc = resultSet.getString(5);

                        String[] data = {
                                Integer.toString(idOddzialu),
                                nazwaOddzialu,
                                miejsceZameldowania,
                                kodPocztowy,
                                miejscowosc,
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }
                    lacz.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
                    String zapytanie = "SELECT * FROM `oddzialy` ORDER BY `Nazwa_Oddzialu`ASC";
                    Statement statement = lacz.createStatement();
                    ResultSet resultSet = statement.executeQuery(zapytanie);
                    while (resultSet.next())
                    {
                        int idOddzialu = resultSet.getInt(1);
                        String nazwaOddzialu = resultSet.getString(2);
                        String miejsceZameldowania = resultSet.getString(3);
                        String kodPocztowy = resultSet.getString(4);
                        String miejscowosc = resultSet.getString(5);

                        String[] data = {
                                Integer.toString(idOddzialu),
                                nazwaOddzialu,
                                miejsceZameldowania,
                                kodPocztowy,
                                miejscowosc,
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }
                    lacz.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
                    String zapytanie = "SELECT * FROM `oddzialy` ORDER BY `Nazwa_Oddzialu` DESC";
                    Statement statement = lacz.createStatement();
                    ResultSet resultSet = statement.executeQuery(zapytanie);
                    while (resultSet.next())
                    {
                        int idOddzialu = resultSet.getInt(1);
                        String nazwaOddzialu = resultSet.getString(2);
                        String miejsceZameldowania = resultSet.getString(3);
                        String kodPocztowy = resultSet.getString(4);
                        String miejscowosc = resultSet.getString(5);

                        String[] data = {
                                Integer.toString(idOddzialu),
                                nazwaOddzialu,
                                miejsceZameldowania,
                                kodPocztowy,
                                miejscowosc,
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }
                    lacz.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        wyczyscFiltryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                wyswietl();
            }
        });
        odswiezButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                wyswietl();
            }
        });
    }

    @Override
    public void wyswietl() {
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            Statement statement = lacz.createStatement();
            String zapytanie2 = "SELECT * FROM oddzialy";
            ResultSet resultSet = statement.executeQuery(zapytanie2);
            while (resultSet.next())
            {
                int idOddzialu = resultSet.getInt(1);
                String nazwaOddzialu = resultSet.getString(2);
                String miejsceZameldowania = resultSet.getString(3);
                String kodPocztowy = resultSet.getString(4);
                String miejscowosc = resultSet.getString(5);

                String[] data = {
                        Integer.toString(idOddzialu),
                        nazwaOddzialu,
                        miejsceZameldowania,
                        kodPocztowy,
                        miejscowosc,
                };

                DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                tableModel.addRow(data);
            }
            lacz.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        Object[][] data = {};
        table1.setModel(new DefaultTableModel(
                data,new String[]{"ID_Odziału","Nazwa Odziału","Miejsce zameldowania","Kod pocztowy","Miejscowosc"}
        ));

        TableColumnModel column = table1.getColumnModel();
        DefaultTableCellRenderer centerRendered = new DefaultTableCellRenderer();
        centerRendered.setHorizontalAlignment(JLabel.CENTER);
        column.getColumn(0).setCellRenderer(centerRendered);
        column.getColumn(1).setCellRenderer(centerRendered);
        column.getColumn(2).setCellRenderer(centerRendered);
        column.getColumn(3).setCellRenderer(centerRendered);
        column.getColumn(4).setCellRenderer(centerRendered);
    }
}
