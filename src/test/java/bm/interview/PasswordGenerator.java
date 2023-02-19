package bm.interview;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.Map;

public final class PasswordGenerator {

    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generate(int length) {
        var sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
//            sb.append(CHARS.charAt(SECURE_RANDOM.nextInt(0, length)));
        }

        return sb.toString();
    }

}
