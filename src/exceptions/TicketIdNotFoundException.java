package exceptions;

public class TicketIdNotFoundException extends RuntimeException{

    public TicketIdNotFoundException() {
    }

    public TicketIdNotFoundException(String message) {
        super(message);
    }

    public TicketIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketIdNotFoundException(Throwable cause) {
        super(cause);
    }

    public TicketIdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
