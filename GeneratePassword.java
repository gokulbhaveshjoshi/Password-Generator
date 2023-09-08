import java.security.SecureRandom;

public class GeneratePassword {
    private static final String UPPER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGIT_STRING = "1234567890";
    private static final String SYMBOL_STRING = "!@#$%^&*()-_=+<>?{}[]";

    public static String generatePassword(int length, boolean upperCase, boolean lowerCase, boolean digitCase, boolean symbolsCase){
        StringBuilder sb = new StringBuilder();
        if (upperCase) {
            sb.append(UPPER_STRING);
        }

        if (lowerCase){
            sb.append(LOWER_STRING);
        }

        if (digitCase) {
            sb.append(DIGIT_STRING);
        }

        if(symbolsCase) {
            sb.append(SYMBOL_STRING);
        }

        if (sb.length() == 0 ) {
            throw new IllegalArgumentException("At least one character must be selected");
        }

        StringBuilder password = new StringBuilder(length);
        SecureRandom sr = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = sr.nextInt(sb.length());
            password.append(sb.charAt(randomIndex));
        }
        return password.toString();
    }
    public static void main(String[] args) {
        System.out.println(generatePassword(8, true, true, true, true));
        System.out.println(generatePassword(8, true, true, true, true));
        System.out.println(generatePassword(8, true, true, true, true));
        System.out.println(generatePassword(0, true, true, true, true));
        System.out.println(generatePassword(8, false, false, false, false));
    }
}
