package CarRentalSystem.UI_Layer;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends JFrame {

    public WelcomeUI() {

        setTitle("Car Rental Marketplace");

        setSize(700, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        // ===== Main Background Panel =====

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(40, 50, 40, 50)
        );


        // ===== Title =====

        JLabel title = new JLabel(
                "CAR RENTAL MARKETPLACE"
        );

        title.setFont(new Font("Arial", Font.BOLD, 32));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Subtitle =====

        JLabel subtitle = new JLabel(
                "Rent Cars Or List Your Own Car For Rent"
        );

        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));

        subtitle.setForeground(Color.DARK_GRAY);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Marketplace Info =====

        JLabel info = new JLabel(
                "Trusted Marketplace • Multiple Locations • Verified Users"
        );

        info.setFont(new Font("Arial", Font.PLAIN, 14));

        info.setForeground(Color.GRAY);

        info.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Buttons =====

        JButton createAccountBtn =
                new JButton("Create Account");

        JButton loginBtn =
                new JButton("Login");


        // Main Button Style

        createAccountBtn.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        createAccountBtn.setMaximumSize(
                new Dimension(260, 50)
        );

        createAccountBtn.setFocusPainted(false);


        // Secondary Button Style

        loginBtn.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        loginBtn.setMaximumSize(
                new Dimension(180, 40)
        );

        loginBtn.setFocusPainted(false);


        createAccountBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Footer =====

        JLabel footer = new JLabel(
                "Safe Rentals • Marketplace Platform • Customer Support"
        );

        footer.setFont(new Font("Arial", Font.PLAIN, 12));

        footer.setForeground(Color.GRAY);

        footer.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Add Components =====

        mainPanel.add(Box.createVerticalGlue());

        mainPanel.add(title);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 15)
        ));

        mainPanel.add(subtitle);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 10)
        ));

        mainPanel.add(info);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 50)
        ));

        mainPanel.add(createAccountBtn);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 20)
        ));

        mainPanel.add(loginBtn);

        mainPanel.add(Box.createRigidArea(
                new Dimension(0, 60)
        ));

        mainPanel.add(footer);

        mainPanel.add(Box.createVerticalGlue());


        add(mainPanel, BorderLayout.CENTER);


        // ===== Actions =====

        createAccountBtn.addActionListener(e -> {

            new RegisterUI();

            dispose();

        });


        loginBtn.addActionListener(e -> {

            new LoginUI();

            dispose();

        });


        setVisible(true);

    }

}