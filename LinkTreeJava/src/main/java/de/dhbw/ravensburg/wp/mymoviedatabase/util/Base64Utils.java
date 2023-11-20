package de.dhbw.ravensburg.wp.mymoviedatabase.util;

import java.util.Base64;

public class Base64Utils {

    public static String encode(byte[] byteArray) {
        return Base64.getEncoder().encodeToString(byteArray);
    }
}
