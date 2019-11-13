package com.zzj.code.chapter5.q4;

/**
 * @author etron
 * @date 2019/11/13 22:10
 */
public class Test {


    /**
     * 时间复杂度O(n)，可以修改输入的数组
     * 得到的数据，有可能并不是排好序的
     * 所以还有一种解法，更适合海量数据
     * @param input
     * @param n
     * @param output
     * @param k
     */
    private static void GetLeastNumbers(int[] input, int n, int[] output, int k) {
        if(input == null || output == null || k > n || n <=0 || k<=0) {
            return;
        }
        int start = 0;
        int end = n - 1;
        int index = partition(input, start, end);
        while(index != k - 1) {
            if(index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for(int i = 0; i < k; ++i) {
            output[i] = input[i];
        }
    }
    private static int partition(int[] numbers, int start, int end) {
        int index = start + (int)(Math.random() * (end - start +1));
        swap(numbers, index, end);

        int small = start - 1;
        for(index = start; index < end ; index ++) {
            if(numbers[index] < numbers[end]) {
                small ++;
                if(small != index) {
                    swap(numbers, small, index);
                }
            }
        }
        small ++;
        swap(numbers, small, end);
        return small;

    }

    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
