package com.zzj.code.chapter2.q9;

public class Test {

    private static long Fibonacci(int n) {
        int[] result = {0, 1};
        if(n < 2) {
            return result[n];
        }

        long fibNMinusOne = 1;
        long fibNMinuxTwo = 0;
        long fibN = 0;
        for(int i = 2; i <= n; i++) {

            // 先计算下一位数的值
            fibN = fibNMinusOne + fibNMinuxTwo;

            // 依次向后移动一位
            fibNMinuxTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }

}
