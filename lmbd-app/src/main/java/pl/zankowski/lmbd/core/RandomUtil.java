package pl.zankowski.lmbd.core;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {

    private static final int DEF_COUNT = 20;

    private RandomUtil() {
    }

    public static String generateActivationKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

}
