import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class List extends NadawcaIOdbiorca implements ILacz,IDodawanie{
    private int czyPolecony;
    private int czyZPotwierdzeniemOdbioru;
    private String status;


    public List(String imieNadawcy, String nazwiskoNadawcy, String adresNadawcy, String kodPocztowyNadawcy, String kpMiejscowoscNadawcy, String imieObdiorcy, String nazwiskoOdbiorcy, String adresObdiorcy, String kodPocztowyOdbiorcy, String kpMiejscowoscOdbiorcy,int czyPolecony, int czyZPotwierdzeniemOdbioru) {
        super(imieNadawcy, nazwiskoNadawcy, adresNadawcy, kodPocztowyNadawcy, kpMiejscowoscNadawcy, imieObdiorcy, nazwiskoOdbiorcy, adresObdiorcy, kodPocztowyOdbiorcy, kpMiejscowoscOdbiorcy);
        this.czyPolecony = czyPolecony;
        this.czyZPotwierdzeniemOdbioru = czyZPotwierdzeniemOdbioru;
        this.status = "Oczekuje do wysłania";
    }

    @Override
    public void Dodaj() throws QueryException {
        Connection lacz = null;
        try {
            lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie ="INSERT INTO `listy` (`Imie_Nadawcy`, `Nazwisko_Nadawcy`, `Adres_Nadawcy`, `Kod_Pocztowy_Nadawcy`, `Kod_Pocztowy_Miejscowosc_Nadawcy`, `Imie_Odbiorcy`, `Nazwisko_Odbiorcy`, `Adres_Odbiorcy`, `Kod_Pocztowy_Odbiorcy`, `Kod_Pocztowy_Miejscowosc_Odbiorcy`, `Czy_Polecony`, `Czy_Z_Potwierdzeniem_Odbioru`,`Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement argument = lacz.prepareStatement(zapytanie);
            argument.setString(1,this.getImieNadawcy());
            argument.setString(2,this.getNazwiskoNadawcy());
            argument.setString(3,this.getAdresNadawcy());
            argument.setString(4,this.getKodPocztowyNadawcy());
            argument.setString(5,this.getKpMiejscowoscNadawcy());
            argument.setString(6,this.getImieObdiorcy());
            argument.setString(7,this.getNazwiskoOdbiorcy());
            argument.setString(8,this.getAdresObdiorcy());
            argument.setString(9,this.getKodPocztowyOdbiorcy());
            argument.setString(10,this.getKpMiejscowoscOdbiorcy());
            argument.setInt(11,this.czyPolecony);
            argument.setInt(12,this.czyZPotwierdzeniemOdbioru);
            argument.setString(13,this.status);


            argument.executeUpdate();
            argument.close();
            lacz.close();
        } catch (SQLException ex) {
            throw new QueryException("Wystąpił błąd w zapytaniu Sql");
        }
    }
}
