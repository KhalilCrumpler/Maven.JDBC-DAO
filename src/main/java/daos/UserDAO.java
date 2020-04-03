package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DAO<User> {
    private static final String INSERT = "INSERT INTO daolab.mock_data" +
            "(first_name, last_name, email, gender, city)" +
            "VALUES(?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM daolab.mock_data WHERE id = ?";
    private static final String GET_ALL = "SELECT * FROM daolab.mock_data";
    private static final String UPDATE = "UPDATE daolab.mock_data SET first_name = ?, last_name = ?, email = ?, gender = ?, city = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM daolab.mock_data WHERE id = ?";

    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public User findByID(int id) {
        User user = null;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(GET_ONE);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender"),
                        resultSet.getString("city")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(GET_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender"),
                        resultSet.getString("city")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User update(User dto) {
        User user = null;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(UPDATE);
            ps.setString(1, dto.getFirst_name());
            ps.setString(2, dto.getLast_name());
            ps.setString(3, dto.getEmail());
            ps.setString(4, dto.getGender());
            ps.setString(5, dto.getCity());
            ps.setInt(6, dto.getId());
            ps.executeUpdate();
            user = this.findByID(dto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User create(User dto) {
        User user = null;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(INSERT);
            ps.setString(1, dto.getFirst_name());
            ps.setString(2, dto.getLast_name());
            ps.setString(3, dto.getEmail());
            ps.setString(4, dto.getGender());
            ps.setString(5, dto.getCity());
            ps.executeUpdate();
            ArrayList<User> players = findAll();
            user = players.get(players.size() - 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void delete(int id) {
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
