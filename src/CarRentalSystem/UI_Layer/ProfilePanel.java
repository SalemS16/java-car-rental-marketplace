package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.UserDAO;
import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    public ProfilePanel() {

        setLayout(
                new BoxLayout(this, BoxLayout.Y_AXIS)
        );

        setBorder(
                BorderFactory.createEmptyBorder(40, 60, 40, 60)
        );


        // ===== Title =====

        JLabel title = new JLabel(
                "My Profile"
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Subtitle =====

        JLabel subtitle = new JLabel(
                "Manage your marketplace identity"
        );

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        subtitle.setForeground(Color.GRAY);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Profile Card =====

        JPanel profileCard = new JPanel();

        profileCard.setLayout(
                new GridLayout(4, 2, 15, 15)
        );

        profileCard.setMaximumSize(
                new Dimension(500, 220)
        );

        profileCard.setBorder(
                BorderFactory.createTitledBorder(
                        "Account Information"
                )
        );


        // ===== Session Data =====

        String customerId =
                SessionManager.getCustomerId();

        String customerName =
                SessionManager.getCustomerName();

        String username =
                SessionManager.getUsername();

        String email =
                SessionManager.getEmail();


        // ===== Add Data =====

        profileCard.add(new JLabel("Customer ID"));

        profileCard.add(new JLabel(customerId));


        profileCard.add(new JLabel("Full Name"));

        profileCard.add(new JLabel(customerName));


        profileCard.add(new JLabel("Username"));

        profileCard.add(new JLabel(username));


        profileCard.add(new JLabel("Email"));

        profileCard.add(new JLabel(email));


        // ===== Marketplace Info =====

        JLabel marketplaceInfo = new JLabel(
                "You can rent cars and list your own vehicles in the marketplace."
        );

        marketplaceInfo.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        marketplaceInfo.setForeground(Color.DARK_GRAY);

        marketplaceInfo.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Buttons =====

        JButton editBtn =
                new JButton("Edit Profile");

        JButton passwordBtn =
                new JButton("Change Password");


        editBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


        editBtn.setMaximumSize(
                new Dimension(220, 40)
        );

        passwordBtn.setMaximumSize(
                new Dimension(220, 40)
        );


        // ===== Edit Profile Action =====

        editBtn.addActionListener(e -> {

            JTextField nameField =
                    new JTextField(
                            SessionManager.getCustomerName()
                    );

            JTextField emailField =
                    new JTextField(
                            SessionManager.getEmail()
                    );

            JTextField phoneField =
                    new JTextField();


            JPanel panel = new JPanel(
                    new GridLayout(3, 2, 10, 10)
            );

            panel.add(new JLabel("Full Name"));

            panel.add(nameField);

            panel.add(new JLabel("Email"));

            panel.add(emailField);

            panel.add(new JLabel("Phone"));

            panel.add(phoneField);


            int result =
                    JOptionPane.showConfirmDialog(

                            this,

                            panel,

                            "Edit Profile",

                            JOptionPane.OK_CANCEL_OPTION

                    );


            if (result == JOptionPane.OK_OPTION) {

                String newName =
                        nameField.getText();

                String newEmail =
                        emailField.getText();

                String newPhone =
                        phoneField.getText();


                UserDAO dao =
                        new UserDAO();


                boolean updated =
                        dao.updateProfile(

                                SessionManager.getCustomerId(),

                                newName,

                                newEmail,

                                newPhone

                        );


                if (updated) {

                    JOptionPane.showMessageDialog(

                            this,

                            "Profile Updated Successfully"

                    );

                }

                else {

                    JOptionPane.showMessageDialog(

                            this,

                            "Profile Update Failed"

                    );

                }

            }

        });

        // ===== Change Password Action =====

        passwordBtn.addActionListener(e -> {

            String newPassword =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter New Password"
                    );

            if (newPassword == null
                    || newPassword.trim().isEmpty()) {

                return;

            }


            UserDAO dao =
                    new UserDAO();


            boolean updated =
                    dao.changePassword(

                            SessionManager.getCustomerId(),

                            newPassword

                    );


            if (updated) {

                JOptionPane.showMessageDialog(
                        this,
                        "Password Changed Successfully"
                );

            }

            else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed To Change Password"
                );

            }

        });


        // ===== Add Components =====

        add(title);

        add(Box.createRigidArea(
                new Dimension(0, 10)
        ));

        add(subtitle);

        add(Box.createRigidArea(
                new Dimension(0, 40)
        ));

        add(profileCard);

        add(Box.createRigidArea(
                new Dimension(0, 25)
        ));

        add(marketplaceInfo);

        add(Box.createRigidArea(
                new Dimension(0, 35)
        ));

        add(editBtn);

        add(Box.createRigidArea(
                new Dimension(0, 15)
        ));

        add(passwordBtn);

    }

}