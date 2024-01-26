import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BazaDanych implements ILacz{
    public BazaDanych()
    {
        try {
            String[] zap = new String[8];
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            zap[0] = "CREATE DATABASE IF NOT EXISTS poczta";
            zap[1] = "USE poczta";
            zap[2] = "CREATE TABLE IF NOT EXISTS `kurierzy` " +
                    "( `ID_Kuriera` int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " `Imie_Kuriera` varchar(20) NOT NULL," +
                    " `Nazwisko_Kuriera` varchar(20) NOT NULL," +
                    " `ID_Rejonu` int(3) DEFAULT NULL )";
            zap[3] = "CREATE TABLE IF NOT EXISTS `listonosze`" +
                    " ( `ID_Listonosza` int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " `Imie_Listonosza` varchar(20) NOT NULL, `Nazwisko_Listonosza` varchar(20) NOT NULL," +
                    " `ID_Rejonu` int(3) DEFAULT NULL )";
            zap[4] = "CREATE TABLE IF NOT EXISTS `listy` " +
                    "( `ID_Listu` int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " `Imie_Nadawcy` varchar(50) NOT NULL," +
                    " `Nazwisko_Nadawcy` varchar(50) NOT NULL," +
                    " `Adres_Nadawcy` varchar(30) NOT NULL," +
                    " `Kod_Pocztowy_Nadawcy` varchar(6) NOT NULL," +
                    " `Kod_Pocztowy_Miejscowosc_Nadawcy` varchar(30) NOT NULL," +
                    " `Imie_Odbiorcy` varchar(50) NOT NULL," +
                    " `Nazwisko_Odbiorcy` varchar(50) NOT NULL," +
                    " `Adres_Odbiorcy` varchar(30) NOT NULL," +
                    " `Kod_Pocztowy_Odbiorcy` varchar(6) NOT NULL," +
                    " `Kod_Pocztowy_Miejscowosc_Odbiorcy` varchar(30) NOT NULL," +
                    " `Czy_Polecony` tinyint(1) NOT NULL, `Czy_Z_Potwierdzeniem_Odbioru` tinyint(1) NOT NULL," +
                    " `ID_Listonosza` int(3) DEFAULT NULL," +
                    " `Status` varchar(20) NOT NULL )";
            zap[5] = "CREATE TABLE IF NOT EXISTS `oddzialy` " +
                    "( `ID_Oddzialu` int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " `Nazwa_Oddzialu` varchar(50) NOT NULL," +
                    " `Miejsce_Zameldowania` varchar(50) NOT NULL," +
                    " `Kod_Pocztowy` varchar(6) NOT NULL," +
                    " `Miejscowosc` varchar(30) NOT NULL )";
            zap[6] = "CREATE TABLE IF NOT EXISTS `paczki` " +
                    "( `ID_Paczki` int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " `Imie_Nadawcy` varchar(50) NOT NULL," +
                    " `Nazwisko_Nadawcy` varchar(50) NOT NULL," +
                    " `Adres_Nadawcy` varchar(30) NOT NULL," +
                    " `Kod_Pocztowy_Nadawcy` varchar(6) NOT NULL," +
                    " `Kod_Pocztowy_Miejscowosc_Nadawcy` varchar(30) NOT NULL," +
                    " `Imie_Odbiorcy` varchar(50) NOT NULL," +
                    " `Nazwisko_Odbiorcy` varchar(50) NOT NULL," +
                    " `Adres_Odbiorcy` varchar(30) NOT NULL," +
                    " `Kod_Pocztowy_Odbiorcy` varchar(6) NOT NULL," +
                    " `Kod_Pocztowy_Miejscowosc_Odbiorcy` varchar(30) NOT NULL," +
                    " `Czy_Delikatna` tinyint(1) NOT NULL," +
                    " `Waga` double NOT NULL," +
                    " `ID_Kuriera` int(3) DEFAULT NULL," +
                    " `Status` varchar(20) NOT NULL )";
            zap[7] = "CREATE TABLE IF NOT EXISTS `rejon` " +
                    "( `ID_Rejonu` int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " `Kod_Rejonu` int(5) NOT NULL," +
                    " `Opis_Rejonu` varchar(200) NOT NULL," +
                    " `ID_Oddzialu` int(3) DEFAULT NULL )";

            Statement statement = lacz.createStatement();
            statement.executeUpdate(zap[0]);
            statement.execute(zap[1]);
            for(int i = 2;i < zap.length;i++)
            {
                statement.executeUpdate(zap[i]);
            }
            lacz.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
