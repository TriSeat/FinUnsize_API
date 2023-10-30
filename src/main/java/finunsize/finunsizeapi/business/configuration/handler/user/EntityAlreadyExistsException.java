package finunsize.finunsizeapi.business.configuration.handler.user;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String name, String email) {
        super("Nome ou email já existem: " + name + " & " + email);
    }
}
