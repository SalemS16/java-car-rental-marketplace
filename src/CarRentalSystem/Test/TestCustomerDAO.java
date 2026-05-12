package CarRentalSystem.Test;

import CarRentalSystem.DAO_Layer.CustomerDAO;

public class TestCustomerDAO {

    public static void main(String[] args) {

        CustomerDAO dao = new CustomerDAO();

        dao.addCustomer(
                "CUS003",
                "Rahul",
                "9999999999",
                "rahul@email.com"
        );

    }
}
