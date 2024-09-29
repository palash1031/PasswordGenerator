import java.security.SecureRandom;

public class PasswordGenerator {

    // Static vars
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "=+!@#$%^&*(){}|[]\\";

    public static String generatePassword(int length, boolean includeSpecialChars, boolean includeNumbers, boolean includeUppercase, boolean includeLowercase) {
        StringBuilder characters = new StringBuilder();
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        // Ensure at least one character from each required set
        if (includeLowercase) {
            password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
            characters.append(LOWERCASE);
        }
        if (includeUppercase) {
            password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
            characters.append(UPPERCASE);
        }
        if (includeNumbers) {
            password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
            characters.append(NUMBERS);
        }
        if (includeSpecialChars) {
            password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
            characters.append(SPECIAL_CHARS);
        }

        // Fill password
        for (int i = password.length(); i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        //shuffle statement
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] passwordArray = input.toCharArray();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }
        return new String(passwordArray);
    }
}
