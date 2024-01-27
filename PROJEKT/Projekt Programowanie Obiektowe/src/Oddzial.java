import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Oddzial implements ILacz,IDodawanie{
    private String nazwaOddzialu;
    private String miejsceZameldowania;
    private String kodPocztowy;
    private String miejscowosc;


    public Oddzial(String nazwaOddzialu, String miejsceZameldowania, String kodPocztowy, String miejscowosc) {
        this.nazwaOddzialu = nazwaOddzialu;
        this.miejsceZameldowania = miejsceZameldowania;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
    }


    @Override
    public void Dodaj() throws QueryException {
        try{
            Connection lacz = DriverManager.getConnection(DBLINK, USERNAME, PASSWORD);
            String zapytanie ="INSERT INTO oddzialy (Nazwa_Oddzialu, Miejsce_Zameldowania, Kod_Pocztowy, Miejscowosc) VALUES (?,?,?,?)";

            PreparedStatement argument = lacz.prepareStatement(zapytanie);
            argument.setString(1,this.nazwaOddzialu);
            argument.setString(2,this.miejsceZameldowania);
            argument.setString(3,this.kodPocztowy);
            argument.setString(4,this.miejscowosc);


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
