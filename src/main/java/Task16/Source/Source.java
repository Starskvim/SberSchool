package Task16.Source;

import java.sql.Connection;
import java.sql.SQLException;

public interface Source {

    public Connection connection() throws SQLException;
}
