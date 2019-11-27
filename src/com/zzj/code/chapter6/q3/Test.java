package com.zzj.code.chapter6.q3;

/**
 * @author etron
 * @date 2019/11/27 17:25
 */
public class Test {
    private static int GetNumberSameAsIndex(int[] numbers, int length) {
        if(numbers == null) {
            return -1;
        }

        int left = 0;
        int right = length - 1;
        while(left <= right) {
            int middle = left + ((right - left) >> 1);
            if(numbers[middle] == middle) {
                return middle;
            }
            if(numbers[middle] > middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
