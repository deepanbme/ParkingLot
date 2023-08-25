package exceptions;

public class ParkingGateNotFoundException extends RuntimeException{
    public ParkingGateNotFoundException() {
    }

    public ParkingGateNotFoundException(String message) {
        super(message);
    }

    public ParkingGateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingGateNotFoundException(Throwable cause) {
        super(cause);
    }

    public ParkingGateNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
