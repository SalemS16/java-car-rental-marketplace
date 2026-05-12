package CarRentalSystem.UI_Layer;

import CarRentalSystem.DAO_Layer.UserDAO;
import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    private JTextField usernameField;

    private JPasswordField passwordField;

    public LoginUI() {

        setTitle("Login");

        setSize(450, 350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        // ===== Title =====

        JLabel title = new JLabel(
                "Login To Your Account",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        title.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 20, 10)
        );

        add(title, BorderLayout.NORTH);


        // ===== Form Panel =====

        JPanel formPanel = new JPanel();

        formPanel.setLayout(
                new GridLayout(2, 2, 10, 10)
        );

        formPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 40, 20, 40)
        );


        formPanel.add(new JLabel("Username / Email:"));

        usernameField = new JTextField();

        formPanel.add(usernameField);


        formPanel.add(new JLabel("Password:"));

        passwordField = new JPasswordField();

        formPanel.add(passwordField);


        add(formPanel, BorderLayout.CENTER);


        // ===== Bottom Panel =====

        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(
                new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)
        );

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 40, 20, 40)
        );


        // ===== Main Login Button =====

        JButton loginBtn =
                new JButton("Login");

        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginBtn.setMaximumSize(
                new Dimension(180, 40)
        );

        loginBtn.setFont(
                new Font("Arial", Font.BOLD, 16)
        );


        // ===== Small Text Buttons =====

        JButton forgotPasswordBtn =
                new JButton("Forgot Password?");

        JButton forgotUsernameBtn =
                new JButton("Forgot Username?");

        JButton backBtn =
                new JButton("Back");


        JButton[] smallButtons = {
                forgotPasswordBtn,
                forgotUsernameBtn,
                backBtn
        };


        for (JButton btn : smallButtons) {

            btn.setBorderPainted(false);

            btn.setContentAreaFilled(false);

            btn.setFocusPainted(false);

            btn.setForeground(Color.BLUE);

            btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        }


        // ===== Add Components =====

        bottomPanel.add(loginBtn);

        bottomPanel.add(Box.createRigidArea(
                new Dimension(0, 18)
        ));

        bottomPanel.add(forgotPasswordBtn);

        bottomPanel.add(Box.createRigidArea(
                new Dimension(0, 5)
        ));

        bottomPanel.add(forgotUsernameBtn);

        bottomPanel.add(Box.createRigidArea(
                new Dimension(0, 5)
        ));

        bottomPanel.add(backBtn);


        add(bottomPanel, BorderLayout.SOUTH);


        // ===== Actions =====

        loginBtn.addActionListener(e -> loginUser());

        backBtn.addActionListener(e -> {

            new WelcomeUI();

            dispose();

        });


        forgotPasswordBtn.addActionListener(e -> {

            String usernameOrEmail =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Username or Email"
                    );

            if (usernameOrEmail == null
                    || usernameOrEmail.trim().isEmpty()) {

                return;

            }


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
                    dao.updatePassword(
                            usernameOrEmail,
                            newPassword
                    );


            if (updated) {

                JOptionPane.showMessageDialog(
                        this,
                        "Password Updated Successfully"
                );

            }

            else {

                JOptionPane.showMessageDialog(
                        this,
                        "Account Not Found"
                );

            }

        });

        forgotUsernameBtn.addActionListener(e -> {

            String email =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Registered Email"
                    );

            if (email == null
                    || email.trim().isEmpty()) {

                return;

            }


            UserDAO dao =
                    new UserDAO();


            String username =
                    dao.getUsernameByEmail(email);


            if (username != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Your Username is: " + username
                );

            }

            else {

                JOptionPane.showMessageDialog(
                        this,
                        "No account found"
                );

            }

        });

        setVisible(true);

    }



    private void loginUser() {

        try {

            String usernameOrEmail =
                    usernameField.getText().trim();

            String password =
                    String.valueOf(passwordField.getPassword());


            if (usernameOrEmail.isEmpty()
                    || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields"
                );

                return;
            }


            UserDAO dao =
                    new UserDAO();


            boolean isValid =
                    dao.loginUser(usernameOrEmail, password);


            if (!isValid) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid username/email or password"
                );

                return;
            }


            String[] userData =
                    dao.getUserDetails(usernameOrEmail);


            SessionManager.startSession(

                    userData[0],
                    userData[1],
                    userData[2],
                    userData[3]

            );


            new MainHomeUI();

            dispose();

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login failed: " + e.getMessage()
            );

        }

    }

}