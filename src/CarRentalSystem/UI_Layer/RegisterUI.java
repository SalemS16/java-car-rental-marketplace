package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.UserDAO;

import javax.swing.*;
import java.awt.*;

public class RegisterUI extends JFrame {

    private JTextField nameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField phoneField;

    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public RegisterUI() {

        setTitle("Create Account");

        setSize(650, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        // ===== Main Panel =====

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(
                new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(30, 80, 30, 80)
        );


        // ===== Title =====

        JLabel title = new JLabel(
                "Create Your Account"
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Subtitle =====

        JLabel subtitle = new JLabel(
                "Rent Cars Or List Your Own Car For Rent"
        );

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        subtitle.setForeground(Color.GRAY);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Form Panel =====

        JPanel formPanel = new JPanel();

        formPanel.setLayout(
                new GridLayout(6, 2, 15, 15)
        );

        formPanel.setMaximumSize(
                new Dimension(450, 300)
        );


        // ===== Fields =====

        formPanel.add(new JLabel("Full Name"));

        nameField = new JTextField();

        formPanel.add(nameField);


        formPanel.add(new JLabel("Username"));

        usernameField = new JTextField();

        formPanel.add(usernameField);


        formPanel.add(new JLabel("Email"));

        emailField = new JTextField();

        formPanel.add(emailField);


        formPanel.add(new JLabel("Phone"));

        phoneField = new JTextField();

        formPanel.add(phoneField);


        formPanel.add(new JLabel("Password"));

        passwordField = new JPasswordField();

        formPanel.add(passwordField);


        formPanel.add(new JLabel("Confirm Password"));

        confirmPasswordField = new JPasswordField();

        formPanel.add(confirmPasswordField);


        // ===== Buttons =====

        JButton createBtn =
                new JButton("Create Account");

        createBtn.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        createBtn.setFocusPainted(false);

        createBtn.setMaximumSize(
                new Dimension(250, 45)
        );

        createBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton loginBtn =
                new JButton("Already have an account? Login");

        loginBtn.setBorderPainted(false);

        loginBtn.setContentAreaFilled(false);

        loginBtn.setForeground(Color.BLUE);

        loginBtn.setFocusPainted(false);

        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Add Components =====

        mainPanel.add(title);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 10)
        ));

        mainPanel.add(subtitle);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 40)
        ));

        mainPanel.add(formPanel);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 35)
        ));

        mainPanel.add(createBtn);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 15)
        ));

        mainPanel.add(loginBtn);


        add(mainPanel, BorderLayout.CENTER);


        // ===== Actions =====

        createBtn.addActionListener(e -> registerUser());

        loginBtn.addActionListener(e -> {

            new LoginUI();

            dispose();

        });


        setVisible(true);

    }



    private void registerUser() {

        try {

            String fullName =
                    nameField.getText().trim();

            String username =
                    usernameField.getText().trim();

            String email =
                    emailField.getText().trim();

            String phone =
                    phoneField.getText().trim();

            String password =
                    String.valueOf(passwordField.getPassword());

            String confirmPassword =
                    String.valueOf(confirmPasswordField.getPassword());


            // ===== Validation =====

            if (fullName.isEmpty()
                    || username.isEmpty()
                    || email.isEmpty()
                    || phone.isEmpty()
                    || password.isEmpty()
                    || confirmPassword.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields"
                );

                return;
            }


            if (!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Passwords do not match"
                );

                return;
            }


            UserDAO dao =
                    new UserDAO();


            dao.registerUser(
                    fullName,
                    username,
                    email,
                    phone,
                    password
            );


            JOptionPane.showMessageDialog(
                    this,
                    "Account Created Successfully"
            );


            new LoginUI();

            dispose();

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Registration failed: " + e.getMessage()
            );

        }

    }

}