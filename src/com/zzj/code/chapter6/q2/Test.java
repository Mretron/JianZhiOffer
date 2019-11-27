package com.zzj.code.chapter6.q2;

/**
 * @author etron
 * @date 2019/11/27 17:17
 */
public class Test {
    private static int GetMissingNumber(int[] numbers) {
        if(numbers == null) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;
        while(left <= right) {
            int middle = (right + left) >> 1;
            if(numbers[middle] != middle) {
                if(middle == 0 || numbers[middle - 1] == middle - 1) {
                    return middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if(left == numbers.length) {
            return numbers.length;
        }

        // 无效的输入，比如数组不是按要求排序的
        // 或者由数字不在0~n-1范围之内的
        return -1;
    }
}
