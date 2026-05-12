package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.RentalDAO;
import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class ReturnCarUI extends JPanel {

    private JTable rentalTable;

    private DefaultTableModel tableModel;

    public ReturnCarUI() {

        setLayout(new BorderLayout());


        // ===== Title =====

        JLabel title = new JLabel(
                "Return Car",
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
                "Car ID",
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

        rentalTable.setRowHeight(28);


        JScrollPane scrollPane =
                new JScrollPane(rentalTable);

        add(scrollPane, BorderLayout.CENTER);


        // ===== Bottom Panel =====

        JPanel bottomPanel = new JPanel();

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );


        JButton returnBtn =
                new JButton("Return Selected Car");


        returnBtn.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        returnBtn.setPreferredSize(
                new Dimension(260, 45)
        );


        bottomPanel.add(returnBtn);

        add(bottomPanel, BorderLayout.SOUTH);


        // ===== Load Data =====

        loadRentals();


        // ===== Action =====

        returnBtn.addActionListener(e -> returnCar());

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

                        rs.getString("car_id"),

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



    private void returnCar() {

        try {

            int selectedRow =
                    rentalTable.getSelectedRow();


            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a rental"
                );

                return;

            }


            int rentalId =
                    Integer.parseInt(
                            tableModel.getValueAt(
                                    selectedRow,
                                    0
                            ).toString()
                    );


            String carId =
                    tableModel.getValueAt(
                            selectedRow,
                            1
                    ).toString();


            int confirm =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Confirm return for Car ID: " + carId + "?",
                            "Return Confirmation",
                            JOptionPane.YES_NO_OPTION
                    );


            if (confirm != JOptionPane.YES_OPTION) {

                return;

            }


            RentalDAO dao =
                    new RentalDAO();


            dao.returnCar(rentalId, carId);


            JOptionPane.showMessageDialog(
                    this,
                    "Car Returned Successfully!"
            );


            loadRentals();

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Return failed"
            );

        }

    }

}