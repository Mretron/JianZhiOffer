package com.zzj.code.chapter6.q16;

import com.zzj.code.algorithm.QuickSort;

/**
 * @author etron
 * @date 2019/11/28 17:43
 */
public class Test {
    private static boolean IsContinuous(int[] numbers) {
        if(numbers == null) {
            return false;
        }

        // 首先进行排序
        QuickSort.quickSort(numbers, 0, numbers.length -1);

        int numberOfZero = 0;
        int numberOfGap = 0;

        // 统计数组中的零数目
        for(int i = 0; i < numbers.length && numbers[i] == 0; ++i) {
            ++numberOfZero;
        }

        // 统计数组中的间隔数目
        int small = numberOfZero;
        int big  = small + 1;
        while(big < numbers.length) {
            //两个数相等，有对子，不可能是顺子
            if(numbers[small] == numbers[big]) {
                return false;
            }

            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            ++big;
        }
        return (numberOfGap > numberOfZero) ? false : true;
    }
}
