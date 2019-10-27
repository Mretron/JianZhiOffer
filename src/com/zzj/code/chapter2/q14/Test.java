package com.zzj.code.chapter2.q14;

public class Test {


    /**
     * 动态规划
     * @param length
     * @return
     */
    private static int maxProductAfterCutting_solution(int length) {

        if(length < 2) {
            return 0;
        }
        if(length == 2) {
            return 1;
        }
        if(length == 3) {
            return 2;
        }

        // 用来保存当前最优解
        int[] products = new int[length + 1];
        products[0] = 0;
        // 初始化长度为1,2,3直接就能想到的值
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;

        for(int i = 4; i<= length; ++i) {
            max = 0;
            for(int j=1; j<=i/2; ++j) {
                int product = products[j] * products[i - j];
                if(max < product) {
                    max = product;
                }
                // 动态规划，将当前最优解保存下来
                products[i] = max;
            }
        }

        max = products[length];
        products = null;
        return max;
    }

    /**
     * 贪婪算法
     * @param length
     * @return
     */
    private static int maxProductAfterCuting_solution2(int length) {
        if(length < 2) {
            return 0;
        }
        if(length == 2) {
            return 1;
        }
        if(length == 3) {
            return 2;
        }

        // 尽可能多地剪去长度为3的绳子段
        int timesOf3 = length/3;

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2x2 > 3x1
        if(length - timesOf3 *3 == 1) {
            timesOf3-=1;
        }
        int timesOf2 = (length - timesOf3 * 3)/2;
        return (int)(Math.pow(3, timesOf3) * (int)(Math.pow(2, timesOf2)));
    }


}
