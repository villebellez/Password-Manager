import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Takes user input and generates a random password of the specified length.
     * @return The generated password.
     */
    static String generatePassword() {
        Random rand = new Random();

        // List of character options for generated passwords.
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '!', '#', '$', '%', '&', '(', ')', '*', '+'};

        // Creating the password by adding a random character one by one until it meets the specified length.
        String pwd = "";
        System.out.println("How many characters would you like your password to have?");
        try {
            int num = scanner.nextInt();
            for (int i = 0; i <= (num); i++) {
                int randomNum = rand.nextInt(chars.length);
                pwd = pwd.concat(String.valueOf(chars[randomNum])); }

        // Error catching in case a non-integer was entered.
        } catch (InputMismatchException e) {
            System.out.println("You must enter a valid number. Please try again.");
            scanner.next();
            generatePassword(); }

        return pwd;
    }

    /**
     * Takes user input and stores credentials into a file.
     * @param the generated password, or default value.
     */
    static void storeCredentials(String password) {

        // Asking the user for their credentials.
        while (true) {
            System.out.println("What is the username you would like to store?");
            String username = scanner.next();
            String pwd;
            if (password.equals("default")) {
                System.out.println("What is the password you would like to store?");
                pwd = scanner.next();
            } else {
                pwd = password;
            }
            System.out.println("What is the website these credentials are for?");
            String website = scanner.next();
            String credentials = "Username: " + username + " || Password: " + pwd + " || Website: " + website + "\n";

            // Checking to see if the input is correct.
            System.out.println("You have entered - " + credentials + "Is this correct? Please type 'yes' or 'no'.");
            String answer = scanner.next();
            String accepted = answer.toLowerCase();

            // Storing the credentials if they're correct, or having the user re-enter them if they're not.
            if (accepted.equals("yes")) {
                File masterList = new File("masterList.txt");
                try {
                    Files.writeString(masterList.toPath(), credentials, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Your credentials have been stored.\n");
                } catch (IOException ex) {
                    System.out.println("There was an error processing your request.");
                }
                break;
            } else if (!accepted.equals("yes") && !accepted.equals("no")) {
                System.out.println("You have entered an invalid input. Please try again.\n");
            }
        }
    }

    /**
     * Allows user to access their previously saved credentials.
     */
    static void accessCredentials() {
        // TODO: access credentials method
    }

    public static void main(String[] args) {
        String logo = """
                 _____                                    _   __  __                                  \s
                |  __ \\                                  | | |  \\/  |                                 \s
                | |__) |_ _ ___ _____      _____  _ __ __| | | \\  / | __ _ _ __   __ _  __ _  ___ _ __\s
                |  ___/ _` / __/ __\\ \\ /\\ / / _ \\| '__/ _` | | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|
                | |  | (_| \\__ \\__ \\\\ V  V / (_) | | | (_| | | |  | | (_| | | | | (_| | (_| |  __/ |  \s
                |_|   \\__,_|___/___/ \\_/\\_/ \\___/|_|  \\__,_| |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|  \s
                   G E N E R A T E   &   S T O R E   Y O U R   C R E D E N T I A L S    __/ |         \s
                                                                                       |___/          \s \n \n""";
        System.out.print(logo);

        // Loops program until user chooses to exit.
        boolean exit = false;
        while (!exit) {
            System.out.println("Would you like to generate a random password, store existing credentials, or access your passwords? \n" +
                    "(Please input '1' for password generation, '2' for storing, '3' for file access, or '4' to exit the program. )");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            // Loops password generator until user finds the generated password acceptable.
            if (menuChoice == 1) {
                while (true) {
                    String password = generatePassword();
                    System.out.println("Your randomly generated password is: " + password);
                    System.out.println("Is this acceptable? Please enter 'yes' or 'no'.");
                    String answer = scanner.next();
                    String accepted = answer.toLowerCase();
                    if (accepted.equals("yes")) {
                        storeCredentials(password);
                        break;
                    } else if (!accepted.equals("yes") && !accepted.equals("no")) {
                        System.out.println("You have entered an invalid input.\n");
                    }
                }
            }
            // Points user to the function allowing them to store their credentials.
            else if (menuChoice == 2) {
                String password = "default";
                storeCredentials(password);
            }

            // Points user to the function allowing them to access their credentials.
            else if (menuChoice == 3) {
                accessCredentials();
                break;
            }

            // Allows user to exit the program.
            else if (menuChoice == 4) {
                System.out.println("Goodbye.");
                exit = true;

                // TODO: this error catching does nothing if you enter a string its still a input mismatch so fix.
            } else System.out.println("You have entered an invalid input. Please try again.\n");
        }
    }
}