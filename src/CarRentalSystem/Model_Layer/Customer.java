package CarRentalSystem.Model_Layer;

public class Customer {

    private String customerID;
    private String customerName;
    private String phone;
    private String email;

    public Customer(String customerID,
                    String customerName,
                    String phone,
                    String email) {

        if (customerName == null || customerName.trim().isEmpty()) {

            throw new InvalidCustomerException(
                    "Customer name cannot be empty"
            );
        }

        this.customerID = customerID;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}