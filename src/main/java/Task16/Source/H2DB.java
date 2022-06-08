package Task16.Source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DB implements Source{

    @Override
    public Connection connection() throws SQLException {
        final Connection connection = DriverManager.getConnection("jdbc:h2:"+ DbConfig.DATABASE_PATH, DbConfig.DATABASE_USER, DbConfig.DATABASE_PASSWORD);
        connection.setAutoCommit(true);
        return connection;
    }

}
