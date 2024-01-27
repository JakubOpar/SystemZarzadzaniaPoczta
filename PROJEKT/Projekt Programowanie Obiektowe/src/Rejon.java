import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rejon implements ILacz,IDodawanie{

    private String opisRejonu; //wsie i miasta jakie obejmuje
    private int kodRejonu;

    public Rejon(int numerRejonu,String opisRejonu) {
        this.opisRejonu = opisRejonu;
        this.kodRejonu = numerRejonu;
    }

    public Rejon()
    {
        this.opisRejonu = "";
        this.kodRejonu = 0;
    }

    public String getOpisRejonu() {
        return opisRejonu;
    }

    public void setOpisRejonu(String opisRejonu) {
        this.opisRejonu = opisRejonu;
    }

    public int getNumerRejonu() {
        return kodRejonu;
    }

    public void setNumerRejonu(int numerRejonu) {
        this.kodRejonu = numerRejonu;
    }


    @Override
    public void Dodaj() throws QueryException {
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie = "INSERT INTO rejon (ID_Rejonu, Kod_Rejonu, Opis_Rejonu, ID_Oddzialu) VALUES (NULL,?,?,NULL)";

            PreparedStatement argument = lacz.prepareStatement(zapytanie);
            argument.setInt(1,this.kodRejonu);
            argument.setString(2,this.opisRejonu);

            argument.executeUpdate();
            argument.close();
            lacz.close();
        }
        catch(SQLException e)
        {
            throw new QueryException("Wystąpił błąd w zapytaniu Sql");
        }
    }
}
