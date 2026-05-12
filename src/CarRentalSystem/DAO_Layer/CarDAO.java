package CarRentalSystem.DAO_Layer;

import CarRentalSystem.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarDAO {

    // ===== ADD CAR =====

    public void addCar(String brand,
                       String model,
                       String category,
                       double pricePerDay,
                       String location,
                       String ownerId) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String carId =
                    "CAR" + System.currentTimeMillis();

            String query =
                    "INSERT INTO car " +
                            "(car_id, brand, model, category, " +
                            "price_per_day, available, owner_id, location) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


            PreparedStatement ps =
                    conn.prepareStatement(query);


            ps.setString(1, carId);

            ps.setString(2, brand);

            ps.setString(3, model);

            ps.setString(4, category);

            ps.setDouble(5, pricePerDay);

            ps.setBoolean(6, true);

            ps.setString(7, ownerId);

            ps.setString(8, location);


            int rows =
                    ps.executeUpdate();


            System.out.println(
                    rows + " Car Inserted Successfully"
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }



    // ===== GET AVAILABLE CARS =====

    public ResultSet getAvailableCarsByLocation(String location) {

        ResultSet rs = null;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM car " +
                            "WHERE location = ? " +
                            "AND available = true";


            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, location);

            rs = ps.executeQuery();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return rs;

    }



    // ===== GET OWNER CARS =====

    public ResultSet getCarsByOwner(String ownerId) {

        ResultSet rs = null;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM car " +
                            "WHERE owner_id = ?";


            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, ownerId);

            rs = ps.executeQuery();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return rs;

    }

}