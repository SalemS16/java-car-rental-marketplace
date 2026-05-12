package CarRentalSystem.Test;

import CarRentalSystem.Database.DBConnection;

import java.sql.Connection;

public class TestConnection {

        public static void main(String[] args) {

            try {

                Connection conn = DBConnection.getConnection();

                if (conn != null) {

                    System.out.println("Database connected successfully!");

                }

            } catch (Exception e) {

                System.out.println("Connection failed!");
                e.printStackTrace();

            }

        }
}
