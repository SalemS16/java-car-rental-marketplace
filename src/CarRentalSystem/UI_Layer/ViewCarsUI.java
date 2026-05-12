package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.CarDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class ViewCarsUI extends JFrame {

    private JTable carTable;

    private DefaultTableModel tableModel;

    private JComboBox<String> locationBox;

    public ViewCarsUI() {

        setTitle("View Available Cars");

        setSize(900, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());


        // ===== Top Panel =====

        JPanel topPanel = new JPanel();

        JLabel title = new JLabel(
                "Available Cars"
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        topPanel.add(title);


        topPanel.add(new JLabel("   Location:"));


        locationBox = new JComboBox<>(new String[] {

                "Pune",
                "Mumbai",
                "Delhi"

        });

        topPanel.add(locationBox);


        JButton searchBtn =
                new JButton("Search");

        topPanel.add(searchBtn);


        add(topPanel, BorderLayout.NORTH);


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


        // ===== Bottom Panel =====

        JPanel bottomPanel = new JPanel();

        JButton closeBtn =
                new JButton("Close");

        bottomPanel.add(closeBtn);

        add(bottomPanel, BorderLayout.SOUTH);


        // ===== Actions =====

        searchBtn.addActionListener(e -> loadCars());

        closeBtn.addActionListener(e -> dispose());


        setVisible(true);

    }



    private void loadCars() {

        try {

            tableModel.setRowCount(0);

            String location =
                    locationBox.getSelectedItem().toString();


            CarDAO dao =
                    new CarDAO();


            ResultSet rs =
                    dao.getAvailableCarsByLocation(location);


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
                    "Failed to load cars"
            );

        }

    }

}