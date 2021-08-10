package edu.miu.cs.cs544.flightreservation.exception;

/**
 * <h1>Group 5 EA Project</h1>
 *
 * <p>This exception is thrown when a bad request is passed to the controller.
 * This should result in an HTTP 400 level error.</p>
 */

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }
}

