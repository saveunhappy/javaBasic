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
        BigDecimal b3 = new BigDecimal("0.7");
        BigDecimal b4 = new BigDecimal("0.7");
        BigDecimal decimal = b3.multiply(b4);
        System.out.println(decimal);
    }
}
