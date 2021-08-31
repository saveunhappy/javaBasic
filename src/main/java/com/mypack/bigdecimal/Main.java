package com.mypack.bigdecimal;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        float f1 = 0.7f;
        float f2 = 0.7f;
        System.out.println(f1 * f2);
        BigDecimal b1 = new BigDecimal(0.7);
        BigDecimal b2 = new BigDecimal(0.7);
        BigDecimal result = b1.multiply(b2);
        System.out.println(result);
        //必须用字符串，否则上面的使用double类型，结果还是不精准的，因为小数都是一直
        //乘2得到0和1的二进制，本来就算不完，用上字符串，就是用小学数学的知识来了，不用二进制了。
        BigDecimal b3 = new BigDecimal("0.7");
        BigDecimal b4 = new BigDecimal("0.7");
        BigDecimal decimal = b3.multiply(b4);
        System.out.println(decimal);
    }
}
