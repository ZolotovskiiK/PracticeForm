package utils;

import java.security.SecureRandom;

public class EnumUtil {
    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}