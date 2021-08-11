package edu.miu.cs.cs544.flightreservation.utils;

import java.util.UUID;

public class Randomizer {
    /**
     * Static method to generate a random ticket Number and Reservation Code
     *
     * @author Eskender & Henok
     */

    public static String generateAlphaNumericCode(int size) {
        String randomCode = UUID.randomUUID().toString();
        randomCode = randomCode.replace("-", "C0G3");
        return randomCode.substring(0, size);
    }

    // Generates a random int with n digits
    public static String generateRandomDigits() {
        // long m = (long) Math.pow(10, n - 1);
        // return "" + m + new Random().nextInt((int) (9 * m));
        // TODO: Implement this better
        double random = Math.random();
        String s = "" + random;
        return s.substring(2) + "0000";
    }

}
