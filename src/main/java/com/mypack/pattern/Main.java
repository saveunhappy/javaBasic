package com.mypack.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        subContain();
    }

    public static void subContain(){
        String input = "123_444_555_666_789";
        String regex = "\\d{3}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()){
            //获取匹配成功的子串
            System.out.println(m.group());
            //匹配成功的子串的范围是[m.start(),m.end()]
            System.out.println(m.start());
            System.out.println(m.end());
        }

    }

    public static void singleCharPattern(){
        //等价于[b|r|r]at、(b|c|r)at
        String regex =  "[bcr]at";
        System.out.println("bat".matches(regex));
        System.out.println("cat".matches(regex));
        System.out.println("rat".matches(regex));
        System.out.println("hat".matches(regex));
    }
    public static void singleCharPattern1(){
        //等价于[b|r|r]at、(b|c|r)at
        String regex =  "foo[^1-5]";
        System.out.println("foo3".matches(regex));
        System.out.println("foo6".matches(regex));
        System.out.println("food".matches(regex));
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
