package voting;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public final class Security {
    private Security() {}

    public static String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder(64);

            for (byte b : bytes) {
                result.append(String.format("%02x", b));
            }

            return result.toString();
        } catch (Exception e) {
            throw new IllegalStateException("SHA-256 is unavailable", e);
        }
    }
}
