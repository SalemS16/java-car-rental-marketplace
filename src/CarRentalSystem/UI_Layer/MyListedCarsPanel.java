package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.CarDAO;
import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class MyListedCarsPanel extends JPanel {

    private JTable carTable;

    private DefaultTableModel tableModel;

    public MyListedCarsPanel() {

        setLayout(new BorderLayout());


        // ===== Title =====

        JLabel title = new JLabel(
                "My Listed Cars",
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

                "Car ID",
                "Brand",
                "Model",
                "Category",
                "Price Per Day",
                "Location",
                "Available"

        };


        tableModel =
                new DefaultTableModel(columns, 0);

        carTable =
                new JTable(tableModel);


        JScrollPane scrollPane =
                new JScrollPane(carTable);

        add(scrollPane, BorderLayout.CENTER);


        loadCars();

    }



    private void loadCars() {

        try {

            tableModel.setRowCount(0);


            String ownerId =
                    SessionManager.getCustomerId();


            CarDAO dao =
                    new CarDAO();


            ResultSet rs =
                    dao.getCarsByOwner(ownerId);


            while (rs.next()) {

                tableModel.addRow(new Object[] {

                        rs.getString("car_id"),

                        rs.getString("brand"),

                        rs.getString("model"),

                        rs.getString("category"),

                        rs.getDouble("price_per_day"),

                        rs.getString("location"),

                        rs.getBoolean("available")

                });

            }

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load listed cars"
            );

        }

    }

}