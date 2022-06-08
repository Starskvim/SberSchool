package Task16.Cache;

import Task16.Source.Source;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CacheServiceImp implements CacheService {
    private final Source source;
    private final Method method;

    public CacheServiceImp(Source source, Method method) {
        this.source = source;
        this.method = method;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = source.connection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    private boolean isTableExist(Connection connection) {
        try {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet rs = dbm.getTables(null, "PUBLIC", method.getName().toUpperCase(), null);
            return rs.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    private void createTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("SET SCHEMA PUBLIC;CREATE TABLE IF NOT EXISTS " + method.getName() + " (id INT PRIMARY KEY AUTO_INCREMENT,val INT NOT NULL);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void cacheIntList(List<Integer> listForCache) {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute("DROP TABLE IF EXISTS " + method.getName());
            System.out.println("Creating table for:" + method.getName());
            createTable(connection);

            PreparedStatement statement =
                    connection.prepareStatement
                            ("INSERT INTO " + method.getName() + " (val) values (?);");
            for (Integer val : listForCache) {
                statement.setInt(1, val);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private int checkCachedLength(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM " + method.getName() + " ORDER BY ID DESC LIMIT 1;");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public List<Integer> getChachedIntList(int n) {
        List<Integer> listFromCache = new ArrayList<>();
        try (Connection connection = getConnection()) {
            if (!isTableExist(connection)) return null;

            if (checkCachedLength(connection) < n) return null;

            ResultSet resultSet = connection.createStatement().executeQuery("SELECT VAL FROM " + method.getName());
            int i = 0;
            while (resultSet.next() && i < n) {
                listFromCache.add(resultSet.getInt(1));
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listFromCache;
    }

}
