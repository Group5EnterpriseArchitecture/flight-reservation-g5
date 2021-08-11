package edu.miu.cs.cs544.flightreservation.exception;

public class DuplicateKeyException extends RuntimeException {

    public DuplicateKeyException() {
    }

    public DuplicateKeyException(String message) {
        super(message);
    }
}
