package com.zzj.code.chapter3.q1;

public class Test {


    /**
     * 自以为题目简单的解法
     * 虽然题目要求不用考虑大数
     * 但是面试官会问如果输入的指数(exponent) 小于1（0和负数）的时候怎么办？
     * @param base
     * @param exponent
     * @return
     */
    private static double Power(double base, int exponent) {
        double result = 1.0;
        for(int i = 1; i <= exponent; ++i) {
            result *= base;
        }
        return result;
    }


    /**
     * 下面的这样虽然考虑完整了些
     * 但是其实该有更高效的解法
     * 求8次方只需要4次方的平方
     */
    private static boolean g_InvalidInput = false;

    private static double Power1(double base, int exponent) {
        g_InvalidInput = false;

        // 如果求0的负次方
        if(new Double(base).equals(0.0) && exponent < 0) {
            g_InvalidInput = true;
            return 0.0;
        }

        int absExponent = 0;
        if(exponent < 0) {
            absExponent = (-1) * exponent;
        }

        double result = PowerWithUnsignedExponent(base, absExponent);
        if(exponent < 0) {
            result = 1.0 / result;
        }

        return result;
    }


    /**
     * 下面的这样虽然考虑完整了些
     * 但是其实该有更高效的解法
     * 求8次方只需要4次方的平方
     */
    private static double PowerWithUnsignedExponent(double base, int exponent) {
        double result = 1.0;
        for(int i = 1; i <= exponent; ++i) {
            result *= base;
        }
        return result;
    }

    private static double PowerWithUnsignedExponent1(double base, int exponent) {

        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }

        double result = PowerWithUnsignedExponent1(base, exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }




}
