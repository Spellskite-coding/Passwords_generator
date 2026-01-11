import java.util.Scanner;
import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Secure Password Generator");
        System.out.print("Password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecial = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, useUpper, useDigits, useSpecial);
        System.out.println("Generated password: " + password);
    }

    public static String generatePassword(int length, boolean useUpper, boolean useDigits, boolean useSpecial) {
        StringBuilder chars = new StringBuilder(LOWER);
        if (useUpper) chars.append(UPPER);
        if (useDigits) chars.append(DIGITS);
        if (useSpecial) chars.append(SPECIAL);

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }

        return password.toString();
    }
}
