import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Listonosz extends Rejon implements ILacz,IDodawanie{
    private String imieListonosza;
    private String nazwiskoListonosza;


    public Listonosz(String imieListonosza, String nazwiskoListonosza, String opisRejonu, int numerRejonu) {
        super(numerRejonu,opisRejonu);
        this.imieListonosza = imieListonosza;
        this.nazwiskoListonosza = nazwiskoListonosza;
    }

    public Listonosz(String imieListonosza, String nazwiskoListonosza)
    {
        this.imieListonosza = imieListonosza;
        this.nazwiskoListonosza = nazwiskoListonosza;
    }

    public void Dodaj() throws QueryException {
        Connection lacz = null;
        try {
            lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie ="INSERT INTO listonosze (Imie_Listonosza, Nazwisko_Listonosza) VALUES (?,?)";

            PreparedStatement argument = lacz.prepareStatement(zapytanie);
            argument.setString(1,this.imieListonosza);
            argument.setString(2,this.nazwiskoListonosza);


            argument.executeUpdate();
            argument.close();
            lacz.close();
        } catch (SQLException ex) {
            throw new QueryException("Wystąpił bład w zapytaniu Sql");
        }
    }
}
