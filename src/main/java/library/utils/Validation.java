package library.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    private static final Scanner reader = new Scanner(System.in).useDelimiter("\n");

    public static String getUserInputString(String message){
        System.out.println(message);
        while (true){
            String userInput = reader.next();
            if (userInput.length() > 5 && userInput.length() < 50) {
                return userInput;
            } else {
                System.out.println("Invalid Input (must be between 5 and 50 characters)");
            }
        }
    }

    public static Long getUserInputIsbn(String message){
        System.out.println(message);
        while(true){
            try {
                Long userInput = reader.nextLong();

                if (getNumberLength(userInput) == 13 || getNumberLength(userInput) == 10) {
                    return userInput;
                } else {
                    System.out.println("Invalid ISBN");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input (ISBN must be a number with 10 or 13 digits)");
                reader.next();
            }
        }
    }

    public static Integer getUserInputInt(String message, int min, int max){
        System.out.println(message);
        while(true){
            try {
                Integer userInput = reader.nextInt();

                if (getNumberLength(userInput) >= min && getNumberLength(userInput) <= max) {
                    return userInput;
                } else {
                    System.out.println("Invalid Input");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be between " + min + " and " + max);
                reader.next();
            }
        }
    }

    public static Boolean getUserInputBoolean(String message){
        System.out.println(message);
        while(true){
            try {
                Boolean userInput = reader.nextBoolean();
                return userInput;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, please enter true or false, with no capital letters");
                reader.next();
            }
        }
    }

    public static int getNumberLength(Long number){
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }

    public static int getNumberLength(Integer number){
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }
}
