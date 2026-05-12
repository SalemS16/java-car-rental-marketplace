package CarRentalSystem.Model_Layer;

public class InvalidRentalException extends RuntimeException{
    public InvalidRentalException(String message){
        super(message);
    }
}
