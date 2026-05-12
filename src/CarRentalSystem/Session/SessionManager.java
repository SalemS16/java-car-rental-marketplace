package CarRentalSystem.Session;

public class SessionManager {

    private static String customerId;

    private static String customerName;

    private static String username;

    private static String email;



    // ===== SET SESSION =====

    public static void startSession(String id,
                                    String name,
                                    String user,
                                    String mail) {

        customerId = id;

        customerName = name;

        username = user;

        email = mail;

    }



    // ===== CLEAR SESSION =====

    public static void clearSession() {

        customerId = null;

        customerName = null;

        username = null;

        email = null;

    }



    // ===== GETTERS =====

    public static String getCustomerId() {

        return customerId;

    }


    public static String getCustomerName() {

        return customerName;

    }


    public static String getUsername() {

        return username;

    }


    public static String getEmail() {

        return email;

    }

}
