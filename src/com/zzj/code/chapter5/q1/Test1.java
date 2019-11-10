package com.zzj.code.chapter5.q1;

/**
 * @author etron
 * @date 2019/11/12 21:01
 */
public class Test1 {

    private static boolean g_bInputInvalid = false;

    public static void main(String[] args) {
        int[] data = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum(data));

    }

    /**
     * 这个方法时间复杂度为O(n)，而且不用改变数组原来的结构
     * 因为这个数字超过一半的次数，所以，最后它一定是把次数设置为1的数字
     * @param numbers
     * @return
     */
    private static int MoreThanHalfNum(int[] numbers) {
        if(CheckInvalidArray(numbers)) {
            return 0;
        }
        int result = numbers[0];
        int times = 1;
        for(int i = 1; i < numbers.length ; i++) {
            if(times == 0) {
                // 当出现的次数用完了，就设置新的数 去 统计次数
                result = numbers[i];
                times = 1;
            } else if(numbers[i] == result) {
                // 相同，出现次数累加
                times++;
            } else {
                times--;
            }
        }
        if(!CheckMoreThanHalf(numbers, numbers.length, result)) {
            result = 0;
        }
        return result;
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
