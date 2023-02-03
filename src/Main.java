import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Arrays of character options for generated passwords.
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] symbols = {'!', '#', '$', '%', '&', '(', ')', '*', '+'};

        boolean exit = false;
        while(!exit) {
            System.out.println("Would you like to generate a random password, store existing credentials, or access your passwords? \n" +
                    "(Please input '1' for password generation, '2' for storing, '3' for file access, or '4' to exit the program. )");
            int input = scanner.nextInt();

            // TODO: generate password code block

            // TODO: store credentials code block

            // TODO: file access code

            if (input == 4) {
                System.out.println("Goodbye.");
                exit = true;
            } else {
                System.out.println("You have entered an invalid input. Please try again.\n");
            }
        }
    }
}