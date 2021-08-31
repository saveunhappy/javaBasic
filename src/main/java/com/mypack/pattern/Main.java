package com.mypack.pattern;

public class Main {
    public static void main(String[] args) {
//        String regex = "[a-zA-Z][a-zA-Z0-9_]{5,17}";
        String regex = "[a-zA-Z]\\w{5,17}";
        System.out.println("x12342314".matches(regex));
    }

    //6~18个字符，可以使用字母、数字、下划线，需以字母开头
    public static boolean validate(String email) {
        if (email == null){
            System.out.println("不能为空");
            return false;
        }
        char[] chars = email.toCharArray();
        if (chars.length < 6 || chars.length > 18){
            System.out.println("必须是6~18个字符");
            return false;
        }
        //字母开头
        if (!isLetter(chars[0])){
            System.out.println("必须以字母开头");
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if(isLetter(c) || isDigit(c) || c == '_') continue;
            System.out.println("必须以字母、数字、下划线组成");
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
