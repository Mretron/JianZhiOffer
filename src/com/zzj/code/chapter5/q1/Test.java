package com.zzj.code.chapter5.q1;

/**
 * @author etron
 * @date 2019/11/12 20:40
 */
public class Test {

    private static boolean g_bInputInvalid = false;

    public static void main(String[] args) {
        int[] data = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum(data));

    }


    /**
     * 时间复杂度为O(n)
     * 这个方法利用的快速排序分块的思想，但是其实会存在改变原来的数组结构的问题
     * 如果面试官要求不能改变数组的数字位置怎么办,详情请看Test1类
     * @param numbers
     * @return
     */
    private static int MoreThanHalfNum(int[] numbers) {
        if(CheckInvalidArray(numbers)) {
            return 0;
        }
        // 首先得到中位值下标
        // 这个数一定在排好序的中位值
        // 因为这个数出现了一半长度次数以上
        int middle = numbers.length >> 2;

        int start = 0;
        int end = numbers.length - 1;

        // 利用快速排序的思想，随机选取一个数分块
        int index = partition(numbers, start, end);

        // 有可能随机选的数字就是中位值，那么就返回
        // 否则循环减少一半的范围去分块
        while(index != middle) {
            if(index < middle) {
                start = index + 1;
                index = partition(numbers, start, end);
            } else if(index > middle) {
                end = index - 1;
                index = partition(numbers, start, end);
            }
        }

        int result = numbers[middle];

        // 这里依然需要去判断是否真的次数超过 数组长度的一半
        // 因为有可能压根不存在这个数
        if(!CheckMoreThanHalf(numbers, numbers.length, result)) {
            result = 0;
        }
        return result;

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

    private static boolean CheckMoreThanHalf(int[] numbers, int length, int number) {
        int times = 0;
        for(int i = 0; i < length; ++i) {
            if(numbers[i] == number) {
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if(times * 2 <= length) {
            g_bInputInvalid = true;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    private static boolean CheckInvalidArray(int[] numbers) {
        g_bInputInvalid = false;
        if(numbers == null) {
            g_bInputInvalid = true;
        }
        return g_bInputInvalid;
    }
}
