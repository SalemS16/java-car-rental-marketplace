package CarRentalSystem.Model_Layer;

public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException(String message){
        super(message);
    }
}
