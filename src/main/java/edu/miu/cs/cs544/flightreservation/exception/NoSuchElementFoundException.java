package edu.miu.cs.cs544.flightreservation.exception;

/**
 *
 * This exception is thrown when a resource cannot be found.
 * Should result in an HTTP 400 level error.
 *
 */
public class NoSuchElementFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoSuchElementFoundException() {
        super();
    }

    public NoSuchElementFoundException(String message) {
        super(message);
    }

}
