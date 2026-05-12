package CarRentalSystem.DAO_Layer;

import CarRentalSystem.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAO {

    public void addCustomer(String id, String name, String phone, String email) {

        try {

            Connection conn = DBConnection.getConnection();

            String query =
                    "INSERT INTO customer VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, email);

            ps.executeUpdate();

            System.out.println("Customer added successfully!");

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
}
