package com.diogosilva.walletcore.utils;

public class Utils {
    public static boolean validateEmail(String email) {
        return (email == null && !email.contains("@"));
    }

    public static boolean validateNif(String nif) {
        return nif != null && nif.matches("\\d{9}");
    }
}
