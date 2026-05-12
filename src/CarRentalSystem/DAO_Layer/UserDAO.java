package CarRentalSystem.DAO_Layer;

import CarRentalSystem.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public void registerUser(String fullName,
                             String username,
                             String email,
                             String phone,
                             String password) {

        try {

            Connection conn = DBConnection.getConnection();

            String customerId =
                    "CUS" + System.currentTimeMillis();

            String query =
                    "INSERT INTO customer " +
                            "(customer_id, customer_name, phone, email, username, password) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, customerId);
            ps.setString(2, fullName);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, username);
            ps.setString(6, password);

            ps.executeUpdate();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }



    public boolean loginUser(String usernameOrEmail,
                             String password) {

        boolean isValid = false;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM customer " +
                            "WHERE (username = ? OR email = ?) " +
                            "AND password = ?";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, usernameOrEmail);
            ps.setString(2, usernameOrEmail);
            ps.setString(3, password);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                isValid = true;

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return isValid;

    }



    public String[] getUserDetails(String usernameOrEmail) {

        String[] userData = null;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM customer " +
                            "WHERE username = ? OR email = ?";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, usernameOrEmail);
            ps.setString(2, usernameOrEmail);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                userData = new String[] {

                        rs.getString("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("username"),
                        rs.getString("email")

                };

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return userData;

    }
    public String getUsernameByEmail(String email) {

        String username = null;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "SELECT username FROM customer " +
                            "WHERE email = ?";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, email);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                username =
                        rs.getString("username");

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return username;

    }
    public boolean updatePassword(String usernameOrEmail,
                                  String newPassword) {

        boolean updated = false;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "UPDATE customer " +
                            "SET password = ? " +
                            "WHERE username = ? OR email = ?";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, newPassword);

            ps.setString(2, usernameOrEmail);

            ps.setString(3, usernameOrEmail);

            int rows =
                    ps.executeUpdate();

            updated = rows > 0;

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return updated;

    }

}