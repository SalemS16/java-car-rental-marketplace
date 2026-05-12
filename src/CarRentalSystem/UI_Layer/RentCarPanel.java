package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.CarDAO;
import CarRentalSystem.DAO_Layer.RentalDAO;
import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class RentCarPanel extends JPanel {

    private JComboBox<String> locationBox;

    private JTable carTable;

    private DefaultTableModel tableModel;

    public RentCarPanel() {

        setLayout(new BorderLayout());


        // ===== Top Panel =====

        JPanel topPanel = new JPanel();

        JLabel title = new JLabel(
                "Rent A Car"
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 28)
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
                new JButton("Search Cars");

        topPanel.add(searchBtn);


        add(topPanel, BorderLayout.NORTH);


        // ===== Table =====

        String[] columns = {

                "Car ID",
                "Brand",
                "Model",
                "Category",
                "Price Per Day",
                "Location"

        };


        tableModel =
                new DefaultTableModel(columns, 0);

        carTable =
                new JTable(tableModel);

        carTable.setRowHeight(28);


        JScrollPane scrollPane =
                new JScrollPane(carTable);

        add(scrollPane, BorderLayout.CENTER);


        // ===== Bottom Section =====

        JPanel bottomPanel = new JPanel();

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );


        JButton rentBtn =
                new JButton("Rent Selected Car");


        rentBtn.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        rentBtn.setPreferredSize(
                new Dimension(250, 45)
        );

        rentBtn.setFocusPainted(false);


        bottomPanel.add(rentBtn);


        add(bottomPanel, BorderLayout.SOUTH);


        // ===== Actions =====

        searchBtn.addActionListener(e -> loadCars());

        rentBtn.addActionListener(e -> rentCar());

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

                        rs.getString("location")

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



    private void rentCar() {

        try {

            int selectedRow =
                    carTable.getSelectedRow();


            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a car"
                );

                return;

            }


            String daysInput =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Rental Days"
                    );


            if (daysInput == null) {

                return;

            }


            int days =
                    Integer.parseInt(daysInput);


            if (days <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Days must be greater than zero"
                );

                return;

            }


            String carId =
                    tableModel.getValueAt(
                            selectedRow,
                            0
                    ).toString();


            double pricePerDay =
                    Double.parseDouble(
                            tableModel.getValueAt(
                                    selectedRow,
                                    4
                            ).toString()
                    );


            double totalPrice =
                    pricePerDay * days;


            int confirm =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Total Price: ₹ " + totalPrice +
                                    "\nConfirm Rental?",
                            "Rental Confirmation",
                            JOptionPane.YES_NO_OPTION
                    );


            if (confirm != JOptionPane.YES_OPTION) {

                return;

            }


            String customerId =
                    SessionManager.getCustomerId();


            RentalDAO dao =
                    new RentalDAO();


            dao.rentCar(
                    carId,
                    customerId,
                    days,
                    totalPrice
            );


            JOptionPane.showMessageDialog(
                    this,
                    "Car Rented Successfully!"
            );


            loadCars();

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Rental failed"
            );

        }

    }

}