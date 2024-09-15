package by.kiok.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {

    private EntityNotFoundException(String message) {
        super(message);
    }

    public static EntityNotFoundException byId(UUID uuid) {
        return new EntityNotFoundException(
                String.format("Entity by id '%s' not found", uuid)
        );
    }
}
