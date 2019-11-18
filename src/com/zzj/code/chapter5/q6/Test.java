package com.zzj.code.chapter5.q6;

/**
 * @author etron
 * @date 2019/11/18 19:34
 */
public class Test {

    private static int digitAtIndex(int index) {
        if(index < 0) {
            return -1;
        }

        // 代表几位数
        int digits = 1;
        while(true) {
            // 得到这个位数的范围有多少个数
            int numbers = countOfIntegers(digits);

            // numbers * digits 就等于在字符中的数字个数
            // 比如3位数乘以（多少个三位数），那么就可以得到这个3位数
            // 在字符串中的长度
            if(index < numbers * digits) {
                // 如果咱们要的index 更小
                // 说明就在这个范围中
                return digitAtIndex(index, digits);
            }

            // 说明不在当前位数的范围中
            // 所以减去这个范围，代表直接越过这个位数的个数
            index -= digits * numbers;
            // 位数加一，去看看下一位的范围有没有被包含
            digits++;

        }
    }

    /**
     * 得到digits位的数字总共有多少个？
     * 例如输入2，则返回两位数（10 ~ 99）的个数90
     * 输入3，返回（100 ~ 999）的个数900
     * @param digits
     * @return
     */
    private static int countOfIntegers(int digits) {
        if(digits == 1) {
            // 如果是1位数，返回10个：（0~9）
            return 10;
        }
        // 2 : 90
        // 3 : 900
        // 4 : 9000
        // 懂我意思吧
        int count = (int)Math.pow(10, digits - 1);
        return 9 * count;
    }

    /**
     * 说明就在这个位数中的范围中
     * @param index
     * @param digits
     * @return
     */
    private static int digitAtIndex(int index, int digits) {
        // 拿到这个位数开始的数字，然后加上能被整除的数
        int number = beginNumber(digits) + index / digits;
        // 得到余数，用位数去减，待会就可以顺着消一位一位的消除
        int indexFromRight = digits - index % digits;
        for(int i = 1; i < indexFromRight; ++i) {
            number /= 10;
        }
        return number % 10;
    }

    /**
     * 得到这个位数开始的数
     * 比如2
     * 就得到100
     * 3 ： 1000
     * @param digits
     * @return
     */
    private static int beginNumber(int digits) {
        if(digits == 1) {
            return 0;
        }
        return (int)Math.pow(10, digits - 1);
    }
}
