import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ZarzadzajListami extends JFrame implements ILacz,IWyswietlanie {
    private JPanel ZarzadzajListamiPanel;
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

    private final int Width = 1600, Height = 800;

    public ZarzadzajListami()
    {
        super("Post Menagment System");
        this.setContentPane(this.ZarzadzajListamiPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Width,Height);
        createTable();
        wyswietl();

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WyborPrzesylka wyborPrzesylka = new WyborPrzesylka();
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajList dodajList = new DodajList();
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
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
                    String zapytanie = "SELECT * FROM `listy` ORDER BY `Status` ASC";
                    Statement statement = lacz.createStatement();
                    ResultSet resultSet = statement.executeQuery(zapytanie);
                    while (resultSet.next())
                    {
                        int idListu = resultSet.getInt(1);
                        String imieNadawcy = resultSet.getString(2);
                        String nazwiskoNadawcy = resultSet.getString(3);
                        String adresNadawcy = resultSet.getString(4);
                        String kodPocztowyNadawcy = resultSet.getString(5);
                        String miejscowoscNadawcy = resultSet.getString(6);
                        String imieOdbiorcy = resultSet.getString(7);
                        String nazwiskoOdbiorcy = resultSet.getString(8);
                        String adresObdiorcy = resultSet.getString(9);
                        String kodPocztowyOdbiorcy = resultSet.getString(10);
                        String miejscowoscOdbiorcy = resultSet.getString(11);
                        int czyPolecony = resultSet.getInt(12);
                        int czyZPotwierdzeniemOdbioru = resultSet.getInt(13);
                        int idListonosza = resultSet.getInt(14);
                        String status = resultSet.getString(15);


                        String tempCzyPolecony = Integer.toString(czyPolecony);
                        if(tempCzyPolecony.equals("0"))
                        {
                            tempCzyPolecony = "NIE";
                        }
                        else
                        {
                            tempCzyPolecony = "TAK";
                        }

                        String tempCzyZPotwierdzeniemOdbioru = Integer.toString(czyZPotwierdzeniemOdbioru);
                        if(tempCzyZPotwierdzeniemOdbioru.equals("0"))
                        {
                            tempCzyZPotwierdzeniemOdbioru = "NIE";
                        }
                        else
                        {
                            tempCzyZPotwierdzeniemOdbioru = "TAK";
                        }

                        String tempIdListonosza = Integer.toString(idListonosza);
                        if(tempIdListonosza.equals("0"))
                        {
                            tempIdListonosza = "Nie przydzielono";
                        }

                        String[] data = {
                                Integer.toString(idListu),
                                imieNadawcy,
                                nazwiskoNadawcy,
                                adresNadawcy,
                                kodPocztowyNadawcy,
                                miejscowoscNadawcy,
                                imieOdbiorcy,
                                nazwiskoOdbiorcy,
                                adresObdiorcy,
                                kodPocztowyOdbiorcy,
                                miejscowoscOdbiorcy,
                                tempCzyPolecony,
                                tempCzyZPotwierdzeniemOdbioru,
                                tempIdListonosza,
                                status
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }

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
                    String zapytanie = "SELECT * FROM `listy` ORDER BY `Status` DESC";
                    Statement statement = lacz.createStatement();
                    ResultSet resultSet = statement.executeQuery(zapytanie);
                    while (resultSet.next())
                    {
                        int idListu = resultSet.getInt(1);
                        String imieNadawcy = resultSet.getString(2);
                        String nazwiskoNadawcy = resultSet.getString(3);
                        String adresNadawcy = resultSet.getString(4);
                        String kodPocztowyNadawcy = resultSet.getString(5);
                        String miejscowoscNadawcy = resultSet.getString(6);
                        String imieOdbiorcy = resultSet.getString(7);
                        String nazwiskoOdbiorcy = resultSet.getString(8);
                        String adresObdiorcy = resultSet.getString(9);
                        String kodPocztowyOdbiorcy = resultSet.getString(10);
                        String miejscowoscOdbiorcy = resultSet.getString(11);
                        int czyPolecony = resultSet.getInt(12);
                        int czyZPotwierdzeniemOdbioru = resultSet.getInt(13);
                        int idListonosza = resultSet.getInt(14);
                        String status = resultSet.getString(15);


                        String tempCzyPolecony = Integer.toString(czyPolecony);
                        if(tempCzyPolecony.equals("0"))
                        {
                            tempCzyPolecony = "NIE";
                        }
                        else
                        {
                            tempCzyPolecony = "TAK";
                        }

                        String tempCzyZPotwierdzeniemOdbioru = Integer.toString(czyZPotwierdzeniemOdbioru);
                        if(tempCzyZPotwierdzeniemOdbioru.equals("0"))
                        {
                            tempCzyZPotwierdzeniemOdbioru = "NIE";
                        }
                        else
                        {
                            tempCzyZPotwierdzeniemOdbioru = "TAK";
                        }

                        String tempIdListonosza = Integer.toString(idListonosza);
                        if(tempIdListonosza.equals("0"))
                        {
                            tempIdListonosza = "Nie przydzielono";
                        }

                        String[] data = {
                                Integer.toString(idListu),
                                imieNadawcy,
                                nazwiskoNadawcy,
                                adresNadawcy,
                                kodPocztowyNadawcy,
                                miejscowoscNadawcy,
                                imieOdbiorcy,
                                nazwiskoOdbiorcy,
                                adresObdiorcy,
                                kodPocztowyOdbiorcy,
                                miejscowoscOdbiorcy,
                                tempCzyPolecony,
                                tempCzyZPotwierdzeniemOdbioru,
                                tempIdListonosza,
                                status
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
                    String zapytanie = "SELECT * FROM `listy` WHERE `ID_Listu` = ? OR `Imie_Nadawcy` LIKE ? OR `Nazwisko_Nadawcy` LIKE ? OR `Adres_Nadawcy` LIKE ? OR `Kod_Pocztowy_Nadawcy` LIKE ? OR `Kod_Pocztowy_Miejscowosc_Nadawcy` LIKE ? OR `Imie_Odbiorcy` LIKE ? OR `Nazwisko_Odbiorcy` LIKE ? OR `Adres_Odbiorcy`LIKE ? OR `Kod_Pocztowy_Odbiorcy` LIKE ? OR `Kod_Pocztowy_Miejscowosc_Odbiorcy` LIKE ? OR `Status` LIKE ?";
                    PreparedStatement statement = lacz.prepareStatement(zapytanie);
                    statement.setString(1,value);
                    statement.setString(2,value);
                    statement.setString(3,value);
                    statement.setString(4,value);
                    statement.setString(5,value);
                    statement.setString(6,value);
                    statement.setString(7,value);
                    statement.setString(8,value);
                    statement.setString(9,value);
                    statement.setString(10,value);
                    statement.setString(11,value);
                    statement.setString(12,value);

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next())
                    {
                        int idListu = resultSet.getInt(1);
                        String imieNadawcy = resultSet.getString(2);
                        String nazwiskoNadawcy = resultSet.getString(3);
                        String adresNadawcy = resultSet.getString(4);
                        String kodPocztowyNadawcy = resultSet.getString(5);
                        String miejscowoscNadawcy = resultSet.getString(6);
                        String imieOdbiorcy = resultSet.getString(7);
                        String nazwiskoOdbiorcy = resultSet.getString(8);
                        String adresObdiorcy = resultSet.getString(9);
                        String kodPocztowyOdbiorcy = resultSet.getString(10);
                        String miejscowoscOdbiorcy = resultSet.getString(11);
                        int czyPolecony = resultSet.getInt(12);
                        int czyZPotwierdzeniemOdbioru = resultSet.getInt(13);
                        int idListonosza = resultSet.getInt(14);
                        String status = resultSet.getString(15);


                        String tempCzyPolecony = Integer.toString(czyPolecony);
                        if(tempCzyPolecony.equals("0"))
                        {
                            tempCzyPolecony = "NIE";
                        }
                        else
                        {
                            tempCzyPolecony = "TAK";
                        }

                        String tempCzyZPotwierdzeniemOdbioru = Integer.toString(czyZPotwierdzeniemOdbioru);
                        if(tempCzyZPotwierdzeniemOdbioru.equals("0"))
                        {
                            tempCzyZPotwierdzeniemOdbioru = "NIE";
                        }
                        else
                        {
                            tempCzyZPotwierdzeniemOdbioru = "TAK";
                        }

                        String tempIdListonosza = Integer.toString(idListonosza);
                        if(tempIdListonosza.equals("0"))
                        {
                            tempIdListonosza = "Nie przydzielono";
                        }

                        String[] data = {
                                Integer.toString(idListu),
                                imieNadawcy,
                                nazwiskoNadawcy,
                                adresNadawcy,
                                kodPocztowyNadawcy,
                                miejscowoscNadawcy,
                                imieOdbiorcy,
                                nazwiskoOdbiorcy,
                                adresObdiorcy,
                                kodPocztowyOdbiorcy,
                                miejscowoscOdbiorcy,
                                tempCzyPolecony,
                                tempCzyZPotwierdzeniemOdbioru,
                                tempIdListonosza,
                                status
                        };

                        DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                        tableModel.addRow(data);
                    }


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        odswiezButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                wyswietl();
            }
        });
        wyczyscFiltryButton.addActionListener(new ActionListener() {
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
            String zapytanie2 = "SELECT * FROM listy";
            ResultSet resultSet = statement.executeQuery(zapytanie2);
            while (resultSet.next())
            {
                int idListu = resultSet.getInt(1);
                String imieNadawcy = resultSet.getString(2);
                String nazwiskoNadawcy = resultSet.getString(3);
                String adresNadawcy = resultSet.getString(4);
                String kodPocztowyNadawcy = resultSet.getString(5);
                String miejscowoscNadawcy = resultSet.getString(6);
                String imieOdbiorcy = resultSet.getString(7);
                String nazwiskoOdbiorcy = resultSet.getString(8);
                String adresObdiorcy = resultSet.getString(9);
                String kodPocztowyOdbiorcy = resultSet.getString(10);
                String miejscowoscOdbiorcy = resultSet.getString(11);
                int czyPolecony = resultSet.getInt(12);
                int czyZPotwierdzeniemOdbioru = resultSet.getInt(13);
                int idListonosza = resultSet.getInt(14);
                String status = resultSet.getString(15);


                String tempCzyPolecony = Integer.toString(czyPolecony);
                if(tempCzyPolecony.equals("0"))
                {
                    tempCzyPolecony = "NIE";
                }
                else
                {
                    tempCzyPolecony = "TAK";
                }

                String tempCzyZPotwierdzeniemOdbioru = Integer.toString(czyZPotwierdzeniemOdbioru);
                if(tempCzyZPotwierdzeniemOdbioru.equals("0"))
                {
                    tempCzyZPotwierdzeniemOdbioru = "NIE";
                }
                else
                {
                    tempCzyZPotwierdzeniemOdbioru = "TAK";
                }

                String tempIdListonosza = Integer.toString(idListonosza);
                if(tempIdListonosza.equals("0"))
                {
                    tempIdListonosza = "Nie przydzielono";
                }

                String[] data = {
                        Integer.toString(idListu),
                        imieNadawcy,
                        nazwiskoNadawcy,
                        adresNadawcy,
                        kodPocztowyNadawcy,
                        miejscowoscNadawcy,
                        imieOdbiorcy,
                        nazwiskoOdbiorcy,
                        adresObdiorcy,
                        kodPocztowyOdbiorcy,
                        miejscowoscOdbiorcy,
                        tempCzyPolecony,
                        tempCzyZPotwierdzeniemOdbioru,
                        tempIdListonosza,
                        status
                };

                DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                tableModel.addRow(data);
            }
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
                data,new String[]{"ID Listu","Imie Nadawcy","Nazwisko Nadawcy","Adres Nadawcy","Kod Pocztowy Nadawcy","Miejscowość Nadawcy","Imie Odbiorcy"
                ,"Nazwisko Odbiorcy","Adres Odbiorcy","Kod Pocztowy Odbiorcy","Miejscowość Odbiorcy","Czy Polecony","Czy z potwierdzeniem odbioru","ID listonosza","Status"}
        ));

        TableColumnModel column = table1.getColumnModel();
        DefaultTableCellRenderer centerRendered = new DefaultTableCellRenderer();
        centerRendered.setHorizontalAlignment(JLabel.CENTER);
        column.getColumn(0).setCellRenderer(centerRendered);
        column.getColumn(1).setCellRenderer(centerRendered);
        column.getColumn(2).setCellRenderer(centerRendered);
        column.getColumn(3).setCellRenderer(centerRendered);
        column.getColumn(4).setCellRenderer(centerRendered);
        column.getColumn(5).setCellRenderer(centerRendered);
        column.getColumn(6).setCellRenderer(centerRendered);
        column.getColumn(7).setCellRenderer(centerRendered);
        column.getColumn(8).setCellRenderer(centerRendered);
        column.getColumn(9).setCellRenderer(centerRendered);
        column.getColumn(10).setCellRenderer(centerRendered);
        column.getColumn(11).setCellRenderer(centerRendered);
        column.getColumn(12).setCellRenderer(centerRendered);
        column.getColumn(13).setCellRenderer(centerRendered);
        column.getColumn(14).setCellRenderer(centerRendered);



    }
}
