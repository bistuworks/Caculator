package com.example.caculator;

import java.math.BigDecimal;

public class CalculateUtils {
    public static double add(double num1, double num2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(num1));
        BigDecimal b2 = new BigDecimal(String.valueOf(num2));
        return b1.add(b2).doubleValue();
    }

    public static double sub(double num1, double num2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(num1));
        BigDecimal b2 = new BigDecimal(String.valueOf(num2));
        return b1.subtract(b2).doubleValue();
    }

    public static double multiply(double num1, double num2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(num1));
        BigDecimal b2 = new BigDecimal(String.valueOf(num2));
        return b1.multiply(b2).doubleValue();
    }

    public static double div(double num1, double num2) {
        return div(num1, num2, 20);
    }

    public static double div(double num1, double num2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or ");
        }
        BigDecimal b1 = new BigDecimal(String.valueOf(num1));
        BigDecimal b2 = new BigDecimal(String.valueOf(num2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
