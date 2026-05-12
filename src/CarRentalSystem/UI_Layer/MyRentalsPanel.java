package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.RentalDAO;
import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class MyRentalsPanel extends JPanel {

    private JTable rentalTable;

    private DefaultTableModel tableModel;

    public MyRentalsPanel() {

        setLayout(new BorderLayout());


        // ===== Title =====

        JLabel title = new JLabel(
                "My Rentals",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 20, 10)
        );

        add(title, BorderLayout.NORTH);


        // ===== Table =====

        String[] columns = {

                "Rental ID",
                "Brand",
                "Model",
                "Days",
                "Total Price",
                "Rental Date"

        };


        tableModel =
                new DefaultTableModel(columns, 0);

        rentalTable =
                new JTable(tableModel);


        JScrollPane scrollPane =
                new JScrollPane(rentalTable);

        add(scrollPane, BorderLayout.CENTER);


        loadRentals();

    }



    private void loadRentals() {

        try {

            tableModel.setRowCount(0);


            String customerId =
                    SessionManager.getCustomerId();


            RentalDAO dao =
                    new RentalDAO();


            ResultSet rs =
                    dao.getCustomerRentals(customerId);


            while (rs.next()) {

                tableModel.addRow(new Object[] {

                        rs.getInt("rental_id"),

                        rs.getString("brand"),

                        rs.getString("model"),

                        rs.getInt("days"),

                        rs.getDouble("total_price"),

                        rs.getTimestamp("rental_date")

                });

            }

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load rentals"
            );

        }

    }

}