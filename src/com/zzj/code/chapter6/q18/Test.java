package com.zzj.code.chapter6.q18;

/**
 * @author etron
 * @date 2019/11/28 18:00
 */
public class Test {

    /**
     * 我有方法，一次遍历，记录最小最大值
     * @param numbers
     * @return
     */
    private static int MaxDiff(int[] numbers){
        if(numbers == null) {
            return 0;
        }

        int min = numbers[0];
        int maxDiff = numbers[1] - min;

        for(int i = 2; i < numbers.length; ++i) {
            if(numbers[i - 1] < min) {
                min = numbers[i - 1];
            }

            int currentDiff = numbers[i] - min;
            if(currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }
        return maxDiff;
    }
}
