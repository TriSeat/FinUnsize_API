package finunsize.finunsizeapi.business.configuration.handler.user;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message, String... attributes) {
        super(message + ": " + String.join(" & ", attributes));
    }
}
