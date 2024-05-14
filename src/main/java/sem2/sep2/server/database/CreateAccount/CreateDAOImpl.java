package sem2.sep2.server.database.CreateAccount;

import sem2.sep2.server.database.DataBaseConnection;
import java.sql.*;

public class CreateDAOImpl implements CreateDAO {

    public CreateDAOImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String addUser(int userid, String username, String password, String userType) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from \"User\" where \"user_id\"=?;");
            statement.setInt(1,userid);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                connection.close();
                return "User ID is already taken";
            } else {
                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO \"User\"(\"userid\", \"username\", \"password\", \"access_type\") VALUES (?,?,?,?);");
                statement2.setInt(1, userid);
                statement2.setString(2, username);
                statement2.setString(3, password);
                statement2.setString(4, userType);
                statement2.executeUpdate();
                connection.close();
                return "User created successfully";
            }
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }
}





}
