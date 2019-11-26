package com.zzj.code.chapter5.q11;

/**
 * @author etron
 * @date 2019/11/26 13:41
 */
public class Test {

    /**
     * 逐个判断每个整数是不是丑数的解法，直观但不够高效
     * @param number
     * @return
     */
    private static boolean IsUgly(int number) {
        while(number % 2 == 0) {
            number /= 2;
        }
        while(number % 3 == 0) {
            number /= 3;
        }
        while(number % 5 == 0) {
            number /= 5;
        }
        return (number == 1) ? true : false;
    }

    private static int GetUglyNumber(int index) {
        if(index <= 0) {
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while(uglyFound < index) {
            ++ number;
            if(IsUgly(number)) {
                ++uglyFound;
            }
        }

        return number;
    }
}
