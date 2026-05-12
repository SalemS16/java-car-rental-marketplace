package CarRentalSystem.UI_Layer;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {

    public AboutPanel() {

        setLayout(
                new BoxLayout(this, BoxLayout.Y_AXIS)
        );

        setBorder(
                BorderFactory.createEmptyBorder(40, 60, 40, 60)
        );


        // ===== Title =====

        JLabel title = new JLabel(
                "About Car Rental Marketplace"
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Subtitle =====

        JLabel subtitle = new JLabel(
                "Peer-To-Peer Car Rental Platform"
        );

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        subtitle.setForeground(Color.GRAY);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Description =====

        JTextArea description = new JTextArea(

                "Car Rental Marketplace is a peer-to-peer platform " +
                        "where users can rent vehicles from others or list " +
                        "their own cars for rent.\n\n" +

                        "The platform supports:\n" +
                        "• User Authentication\n" +
                        "• Vehicle Listings\n" +
                        "• Location-Based Search\n" +
                        "• Rental Booking\n" +
                        "• Rental History Tracking\n" +
                        "• Marketplace Inventory Management"

        );

        description.setEditable(false);

        description.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        description.setLineWrap(true);

        description.setWrapStyleWord(true);

        description.setBackground(
                getBackground()
        );

        description.setMaximumSize(
                new Dimension(700, 220)
        );


        // ===== Developer Card =====

        JPanel developerCard = new JPanel();

        developerCard.setLayout(
                new GridLayout(3, 2, 15, 15)
        );

        developerCard.setMaximumSize(
                new Dimension(500, 150)
        );

        developerCard.setBorder(
                BorderFactory.createTitledBorder(
                        "Developer Information"
                )
        );


        developerCard.add(new JLabel("Developer"));

        developerCard.add(new JLabel("Salem Saudagar"));


        developerCard.add(new JLabel("Project Type"));

        developerCard.add(new JLabel(
                "Java Swing Marketplace Application"
        ));


        developerCard.add(new JLabel("Technology"));

        developerCard.add(new JLabel(
                "Java • Swing • JDBC • PostgreSQL"
        ));


        // ===== Support Label =====

        JLabel support = new JLabel(
                "Support Contact: support@carmarketplace.com"
        );

        support.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        support.setForeground(Color.GRAY);

        support.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ===== Add Components =====

        add(title);

        add(Box.createRigidArea(
                new Dimension(0, 10)
        ));

        add(subtitle);

        add(Box.createRigidArea(
                new Dimension(0, 35)
        ));

        add(description);

        add(Box.createRigidArea(
                new Dimension(0, 35)
        ));

        add(developerCard);

        add(Box.createRigidArea(
                new Dimension(0, 30)
        ));

        add(support);

    }

}