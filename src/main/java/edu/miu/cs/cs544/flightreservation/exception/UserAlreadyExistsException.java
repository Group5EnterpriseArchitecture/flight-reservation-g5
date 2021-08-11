package edu.miu.cs.cs544.flightreservation.exception;

/**
 * <h1>Group 5 EA Project</h1>
 *
 * <p>This exception is thrown when a bad request is passed to the controller.
 * This should result in an HTTP 400 level error.</p>
 */

public class UserAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException() {
        super();
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

