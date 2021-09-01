package com.mypack.pattern;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //提取重叠字母、数字(字母字母数字数字)
        //aa11 提取出a,1
        //aa12不符合aabb不符合
        String s1 = "aa11+bb23-mj33*dd44/5566%ff77";
        String regex = "([a-z])\\1(\\d)\\2";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s1);
        while (m.find()) {
            System.out.println(m.group());
            System.out.println("-------------");
            System.out.println(m.group(1) + "_" + m.group(2));
        }
    }

    private static void replaceDigit() {
        String s1 = "ab12c3d456efg7h89i1011jk12lmn";
        //连续的数字
        String s2 = s1.replaceAll("\\d+", "**");
        //连续的两个数字
        String s3 = s1.replaceAll("\\d{2}", "**");
        System.out.println(s2);
        System.out.println(s3);
    }

    private static void replaceWords() {
        String s1 = "The row we are looking for is row 8.";
        System.out.println(s1.replace("row", "line"));
        System.out.println("---------------------");
        System.out.println(s1.replaceAll("\\brow\\b", "line"));
        System.out.println();
        String s2 = "Tomorrow I will wear in brown standing in row 10";
        System.out.println(s2.replace("row", "line"));
        System.out.println("---------------------");
        System.out.println(s2.replaceAll("\\brow\\b", "line"));
    }

    public static String reverse(String s) {
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    private static void usualMode() {
        String regex = ".";
        String input = "\r\n";
        findAll(regex, input);
        System.out.println("---------------");
        findAll(regex, input, Pattern.DOTALL);
        System.out.println("---------------");
        findAll(regex, input, Pattern.MULTILINE);
        System.out.println("---------------");
        findAll(regex, input, Pattern.DOTALL | Pattern.MULTILINE);
        System.out.println("------------------");
    }

    private static void capturingGroupReverse() {
        /**
         * 括号里面说明要出现两个连续的数字，后面的1就是要取第几个捕获组，第一个的结果是12，那么后面引用的
         * 第一个捕获组就得是12，就是里面的内容都得一样了，否则就是(\\d\\d){2}这样了
         */
        String regex = "(\\d\\d)\\1";
        System.out.println("1212".matches(regex));
        System.out.println("1234".matches(regex));
        String regex1 = "([a-z]{2})([A-Z]{2})\\2\\1";

        System.out.println("mjPKPKmj".matches(regex1));
        System.out.println("mjPKmjPK".matches(regex1));
    }


    private static void capturingGroup() {
        String regex1 = "dog{3}";
        //do是前面一定要有的，g和{3}相匹配，出现三次。
        System.out.println("doggg".matches(regex1));
        String regex2 = "[dog]{3}";
        System.out.println("ddd".matches(regex2));
        System.out.println("ooo".matches(regex2));
        System.out.println("ggg".matches(regex2));
        System.out.println("dog".matches(regex2));
        System.out.println("gog".matches(regex2));
        System.out.println("gdo".matches(regex2));
        //用了小括号就要求必须完全匹配
        String regex3 = "(dog){3}";
        System.out.println("dogdogdog".matches(regex3));
        System.out.println("ddddddddd".matches(regex3));

    }

    private static void regexPattern() {
        String input = "afooaaaaaafooa";
        /**
         * 贪婪就是直接把所有的吞进去，然后找到最长的，就匹配一次
         */
        findAll(".*foo", input);//贪婪
        /**
         * 这个是从刚开始慢慢往后走，有就返回了.然后，前面匹配过的就不要了，继续往后走，匹配多次
         */
        System.out.println();
        findAll(".*?foo", input);//勉强
        System.out.println();
        /**
         *
         */
        findAll(".*+foo", input);//独占
    }

    public static void findAll(String regex, String input) {
        findAll(regex, input, 0);
    }

    public static void findAll(String regex, String input, int flags) {
        if (regex == null || input == null) return;
        Pattern p = Pattern.compile(regex, flags);
        Matcher m = p.matcher(input);
        boolean found = false;
        while (m.find()) {
            found = true;
            System.out.format("\"%s\",[%d,%d)%n", m.group(), m.start(), m.end());
        }
        if (!found) {
            System.out.println("No match.");
        }
    }

    public static void subContain() {
        String input = "123_444_555_666_789";
        String regex = "\\d{3}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()) {
            //获取匹配成功的子串
            System.out.println(m.group());
            //匹配成功的子串的范围是[m.start(),m.end()]
            System.out.println(m.start());
            System.out.println(m.end());
        }

    }

    public static void singleCharPattern() {
        //等价于[b|r|r]at、(b|c|r)at
        String regex = "[bcr]at";
        System.out.println("bat".matches(regex));
        System.out.println("cat".matches(regex));
        System.out.println("rat".matches(regex));
        System.out.println("hat".matches(regex));
    }

    public static void singleCharPattern1() {
        //等价于[b|r|r]at、(b|c|r)at
        String regex = "foo[^1-5]";
        System.out.println("foo3".matches(regex));
        System.out.println("foo6".matches(regex));
        System.out.println("food".matches(regex));
    }


    //6~18个字符，可以使用字母、数字、下划线，需以字母开头
    public static boolean validate(String email) {
        if (email == null) {
            System.out.println("不能为空");
            return false;
        }
        char[] chars = email.toCharArray();
        if (chars.length < 6 || chars.length > 18) {
            System.out.println("必须是6~18个字符");
            return false;
        }
        //字母开头
        if (!isLetter(chars[0])) {
            System.out.println("必须以字母开头");
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (isLetter(c) || isDigit(c) || c == '_') continue;
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
