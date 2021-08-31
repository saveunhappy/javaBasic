package com.mypack.pattern;

public class Main {
    public static void main(String[] args) {

    }

    //6~18个字符，可以使用字母、数字、下划线，需以字母开头
    public static boolean validate(String email) {
        if (email == null) return false;
        char[] chars = email.toCharArray();
        if (chars.length < 6 || chars.length > 18) return false;
        //字母开头
        if (!isLetter(chars[0])) return false;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if(isLetter(c) || isDigit(c) || c == '_') continue;
            return false;
        }
        return true;
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

}
