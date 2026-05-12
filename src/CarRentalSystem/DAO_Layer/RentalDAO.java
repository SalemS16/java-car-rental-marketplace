package CarRentalSystem.DAO_Layer;

import CarRentalSystem.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RentalDAO {

    // ===== RENT CAR =====

    public void rentCar(String carId,
                        String customerId,
                        int days,
                        double totalPrice) {

        try {

            Connection conn =
                    DBConnection.getConnection();


            // ===== Insert Rental =====

            String rentalQuery =
                    "INSERT INTO rental " +
                            "(car_id, customer_id, days, total_price) " +
                            "VALUES (?, ?, ?, ?)";


            PreparedStatement rentalPs =
                    conn.prepareStatement(rentalQuery);

            rentalPs.setString(1, carId);

            rentalPs.setString(2, customerId);

            rentalPs.setInt(3, days);

            rentalPs.setDouble(4, totalPrice);

            rentalPs.executeUpdate();


            // ===== Update Car Availability =====

            String updateQuery =
                    "UPDATE car " +
                            "SET available = false " +
                            "WHERE car_id = ?";


            PreparedStatement updatePs =
                    conn.prepareStatement(updateQuery);

            updatePs.setString(1, carId);

            updatePs.executeUpdate();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }



    // ===== GET CUSTOMER RENTALS =====

    public ResultSet getCustomerRentals(String customerId) {

        ResultSet rs = null;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "SELECT r.rental_id, " +
                            "r.car_id, " +
                            "c.brand, " +
                            "c.model, " +
                            "r.days, " +
                            "r.total_price, " +
                            "r.rental_date " +
                            "FROM rental r " +
                            "JOIN car c " +
                            "ON r.car_id = c.car_id " +
                            "WHERE r.customer_id = ? " +
                            "ORDER BY r.rental_date DESC";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, customerId);

            rs = ps.executeQuery();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return rs;

    }



    // ===== RETURN CAR =====

    public void returnCar(int rentalId,
                          String carId) {

        try {

            Connection conn =
                    DBConnection.getConnection();


            // ===== Delete Rental =====

            String deleteQuery =
                    "DELETE FROM rental " +
                            "WHERE rental_id = ?";


            PreparedStatement deletePs =
                    conn.prepareStatement(deleteQuery);

            deletePs.setInt(1, rentalId);

            deletePs.executeUpdate();


            // ===== Make Car Available Again =====

            String updateQuery =
                    "UPDATE car " +
                            "SET available = true " +
                            "WHERE car_id = ?";


            PreparedStatement updatePs =
                    conn.prepareStatement(updateQuery);

            updatePs.setString(1, carId);

            updatePs.executeUpdate();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

}