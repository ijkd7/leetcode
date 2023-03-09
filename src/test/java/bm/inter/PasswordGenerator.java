package bm.inter;

import java.security.SecureRandom;

public final class PasswordGenerator {

    private static final String CHARS = "abcdef";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generate(int length) {
        var sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
//            sb.append(CHARS.charAt(SECURE_RANDOM.nextInt(0, length)));
        }

        return sb.toString();
    }

}
