import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kurier extends Rejon implements ILacz,IDodawanie{
    private String imieKuriera;
    private String nazwiskoKuriera;

    public Kurier(String imieKuriera,String nazwiskoKuriera,String opisRejonu, int numerRejonu)
    {
        super(numerRejonu,opisRejonu);
        this.imieKuriera = imieKuriera;
        this.nazwiskoKuriera = nazwiskoKuriera;
    }

    public Kurier(String imieKuriera, String nazwiskoKuriera)
    {
        this.imieKuriera = imieKuriera;
        this.nazwiskoKuriera = nazwiskoKuriera;
    }

    public void Dodaj() throws QueryException
    {
        Connection lacz = null;
        try {
            lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie ="INSERT INTO kurierzy (Imie_Kuriera, Nazwisko_Kuriera) VALUES (?,?)";

            PreparedStatement argument = lacz.prepareStatement(zapytanie);
            argument.setString(1,this.imieKuriera);
            argument.setString(2,this.nazwiskoKuriera);


            argument.executeUpdate();
            argument.close();
            lacz.close();
        } catch (SQLException ex) {
            throw new QueryException("Wystąpił błąd w zapytania Sql");
        }
    }

}
