package com.zzj.code.chapter6.q10;

/**
 * @author etron
 * @date 2019/11/28 13:44
 */
public class Test {
    private static void FindContinuousSequence(int sum) {
        if(sum < 3) {
            return;
        }
        int small = 1;
        int big = 2;
        // 我们只需要small一直增加到(1+s)/2为止
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while(small < middle) {
            if(curSum == sum) {
                PrintContinuousSequence(small, big);
            }

            while(curSum > sum && small < middle) {
                curSum -= small;
                small++;

                if(curSum == sum) {
                    PrintContinuousSequence(small, big);
                }
            }

            big ++;
            curSum += big;
        }
    }

    private static void PrintContinuousSequence(int small, int big) {
        for(int i = small; i <= big; ++i) {
            System.out.printf("%d", i);
            System.out.println();
        }
    }
}
