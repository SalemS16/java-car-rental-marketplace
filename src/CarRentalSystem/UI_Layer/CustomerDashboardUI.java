package CarRentalSystem.UI_Layer;

import CarRentalSystem.Session.SessionManager;

import javax.swing.*;
import java.awt.*;

public class CustomerDashboardUI extends JFrame {

    public CustomerDashboardUI() {

        setTitle("Customer Dashboard");

        setSize(1000, 650);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        // ===== Sidebar =====

        JPanel sidebar = new JPanel();

        sidebar.setPreferredSize(
                new Dimension(220, 0)
        );

        sidebar.setBackground(
                new Color(35, 35, 35)
        );

        sidebar.setLayout(
                new BoxLayout(sidebar, BoxLayout.Y_AXIS)
        );


        JLabel logo = new JLabel(
                "MENU",
                SwingConstants.CENTER
        );

        logo.setForeground(Color.WHITE);

        logo.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        logo.setBorder(
                BorderFactory.createEmptyBorder(30, 0, 30, 0)
        );

        sidebar.add(logo);


        // ===== Menu Buttons =====

        String[] menuItems = {

                "Home",
                "Rent a Car",
                "Give Car on Rent",
                "My Rentals",
                "My Listed Cars",
                "Profile",
                "About",
                "Logout"

        };


        JPanel contentPanel = new JPanel();

        CardLayout cardLayout = new CardLayout();

        contentPanel.setLayout(cardLayout);


        // ===== Panels =====

        contentPanel.add(createHomePanel(), "Home");

        contentPanel.add(new RentCarPanel(), "Rent a Car");

        contentPanel.add(new ListCarPanel(), "Give Car on Rent");

        contentPanel.add(new MyRentalsPanel(), "My Rentals");

        contentPanel.add(new MyListedCarsPanel(), "My Listed Cars");

        contentPanel.add(new ProfilePanel(), "Profile");

        contentPanel.add(new AboutPanel(), "About");


        // ===== Buttons =====

        for (String item : menuItems) {

            JButton btn = new JButton(item);

            btn.setMaximumSize(
                    new Dimension(220, 45)
            );

            btn.setFocusPainted(false);

            btn.setBackground(
                    new Color(50, 50, 50)
            );

            btn.setForeground(Color.WHITE);

            btn.setBorderPainted(false);

            btn.setFont(
                    new Font("Arial", Font.PLAIN, 16)
            );

            btn.setAlignmentX(Component.CENTER_ALIGNMENT);


            sidebar.add(btn);

            sidebar.add(Box.createRigidArea(
                    new Dimension(0, 8)
            ));


            btn.addActionListener(e -> {

                if (item.equals("Logout")) {

                    SessionManager.clearSession();

                    new WelcomeUI();

                    dispose();

                }

                else {

                    cardLayout.show(contentPanel, item);

                }

            });

        }


        add(sidebar, BorderLayout.WEST);

        add(contentPanel, BorderLayout.CENTER);


        setVisible(true);

    }



    // ===== Home Panel =====

    private JPanel createHomePanel() {

        JPanel panel = new JPanel();

        panel.setLayout(
                new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(50, 50, 50, 50)
        );


        JLabel welcome = new JLabel(
                "Welcome, " +
                        SessionManager.getCustomerName()
        );

        welcome.setFont(
                new Font("Arial", Font.BOLD, 32)
        );

        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel subtitle = new JLabel(
                "Rent Cars Or List Your Own Car For Rent"
        );

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        subtitle.setForeground(Color.GRAY);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel info = new JLabel(
                "Trusted Marketplace • Multiple Locations • Verified Users"
        );

        info.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        info.setForeground(Color.GRAY);

        info.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(Box.createVerticalGlue());

        panel.add(welcome);

        panel.add(Box.createRigidArea(
                new Dimension(0, 15)
        ));

        panel.add(subtitle);

        panel.add(Box.createRigidArea(
                new Dimension(0, 10)
        ));

        panel.add(info);

        panel.add(Box.createVerticalGlue());


        return panel;

    }

}