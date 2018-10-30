package Q1.Q3;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpringJDBC {
    public static DataSource dataSource;

    public SpringJDBC() {
    }

    public SpringJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void preparedStatement() throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
        }
    }
}
