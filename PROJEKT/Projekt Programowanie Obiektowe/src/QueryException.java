import java.sql.SQLException;

public class QueryException extends SQLException {
    public QueryException(String message)
    {
        super(message);
    }
}
