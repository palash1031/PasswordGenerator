import java.util.Scanner;

public class PasswordMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Does your password field have any requirements? [Yes or No] (or \"quit\" to quit the program): ");
            String requirementsV1 = input.next();
            String requirementsNew = requirementsV1.toLowerCase();

            switch (requirementsNew) {
                case "yes":
                    System.out.print("How many characters must your password be? ");
                    int characterCount = input.nextInt();

                    System.out.print("Does it require special characters? [Yes or No] ");
                    boolean requireSpecialChars = input.next().toLowerCase().equals("yes");

                    System.out.print("Does it require numbers? [Yes or No] ");
                    boolean requireNumbers = input.next().toLowerCase().equals("yes");

                    System.out.print("Does it require uppercase letters? [Yes or No] ");
                    boolean requireUppercase = input.next().toLowerCase().equals("yes");

                    System.out.print("Does it require lowercase letters? [Yes or No] ");
                    boolean requireLowercase = input.next().toLowerCase().equals("yes");

                    // min required length
                    int minRequiredLength = 0;
                    if (requireSpecialChars) minRequiredLength++;
                    if (requireNumbers) minRequiredLength++;
                    if (requireUppercase) minRequiredLength++;
                    if (requireLowercase) minRequiredLength++;

                    // Adjust characterCount
                    if (characterCount < minRequiredLength) {
                        System.out.println("The specified length is insufficient. Adjusting to minimum required length: " + minRequiredLength);
                        characterCount = minRequiredLength;
                    }

                    // Generate password
                    String password = PasswordGenerator.generatePassword(characterCount, requireSpecialChars, requireNumbers, requireUppercase, requireLowercase);

                    // Validation if
                    if (PasswordValidator.isValid(password, requireSpecialChars, requireNumbers, requireUppercase, requireLowercase)) {
                        System.out.println("Generated password: " + password);
                    } else {
                        System.out.println("Failed to generate a valid password with the given requirements.");
                    }

                    running = false;
                    break;

                case "no":
                    // Generate a random password of default length 
                    String randomPassword = PasswordGenerator.generatePassword(12, false, true, true, true);
                    System.out.println("Generated random password: " + randomPassword);

                    running = false;
                    break;

                case "quit":
                    System.out.println("Quitting the program...");
                    running = false;
                    break;

                default:
                    System.out.println("Please input a valid option (Yes or No).");
                    break;
            }
        }

        input.close();
    }
}
