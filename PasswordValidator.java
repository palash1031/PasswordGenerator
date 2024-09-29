public class PasswordValidator {

    public static boolean isValid(String password, boolean requireSpecialChars, boolean requireNumbers, boolean requireUppercase, boolean requireLowercase) {
        if (requireSpecialChars && !password.matches(".*[=+!@#$%^&*(){}|\\[\\]\\\\].*")) return false;
        if (requireNumbers && !password.matches(".*[0-9].*")) return false;
        if (requireUppercase && !password.matches(".*[A-Z].*")) return false;
        if (requireLowercase && !password.matches(".*[a-z].*")) return false;

        return true;
    }
}
