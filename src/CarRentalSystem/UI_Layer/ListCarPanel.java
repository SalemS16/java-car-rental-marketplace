package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.CarDAO;
import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import java.awt.*;

public class ListCarPanel extends JPanel {

    private JTextField brandField;

    private JTextField modelField;

    private JTextField categoryField;

    private JTextField priceField;

    private JTextField locationField;

    public ListCarPanel() {

        setLayout(
                new BoxLayout(this, BoxLayout.Y_AXIS)
        );

        setBorder(
                BorderFactory.createEmptyBorder(40, 80, 40, 80)
        );


        JLabel title = new JLabel(
                "Give Your Car On Rent"
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel subtitle = new JLabel(
                "List your vehicle in the marketplace"
        );

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        subtitle.setForeground(Color.GRAY);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel formPanel = new JPanel();

        formPanel.setLayout(
                new GridLayout(5, 2, 15, 15)
        );

        formPanel.setMaximumSize(
                new Dimension(500, 250)
        );


        formPanel.add(new JLabel("Brand"));

        brandField = new JTextField();

        formPanel.add(brandField);


        formPanel.add(new JLabel("Model"));

        modelField = new JTextField();

        formPanel.add(modelField);


        formPanel.add(new JLabel("Category"));

        categoryField = new JTextField();

        formPanel.add(categoryField);


        formPanel.add(new JLabel("Price Per Day"));

        priceField = new JTextField();

        formPanel.add(priceField);


        formPanel.add(new JLabel("Location"));

        locationField = new JTextField();

        formPanel.add(locationField);


        JButton submitBtn =
                new JButton("List My Car");

        submitBtn.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitBtn.setMaximumSize(
                new Dimension(220, 45)
        );


        add(title);

        add(Box.createRigidArea(
                new Dimension(0, 10)
        ));

        add(subtitle);

        add(Box.createRigidArea(
                new Dimension(0, 35)
        ));

        add(formPanel);

        add(Box.createRigidArea(
                new Dimension(0, 30)
        ));

        add(submitBtn);


        submitBtn.addActionListener(e -> addCar());

    }



    private void addCar() {

        try {

            String brand =
                    brandField.getText().trim();

            String model =
                    modelField.getText().trim();

            String category =
                    categoryField.getText().trim();

            String location =
                    locationField.getText().trim();

            double price =
                    Double.parseDouble(
                            priceField.getText().trim()
                    );


            if (brand.isEmpty()
                    || model.isEmpty()
                    || category.isEmpty()
                    || location.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields"
                );

                return;
            }


            String ownerId =
                    SessionManager.getCustomerId();


            CarDAO dao =
                    new CarDAO();


            dao.addCar(
                    brand,
                    model,
                    category,
                    price,
                    location,
                    ownerId
            );


            JOptionPane.showMessageDialog(
                    this,
                    "Car Listed Successfully!"
            );


            brandField.setText("");

            modelField.setText("");

            categoryField.setText("");

            priceField.setText("");

            locationField.setText("");

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input"
            );

        }

    }

}