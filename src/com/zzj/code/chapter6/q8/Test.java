package com.zzj.code.chapter6.q8;

import java.util.Arrays;

/**
 * @author etron
 * @date 2019/11/28 13:26
 */
public class Test {

    private static int FindNumberAppearingOnce(int[] numbers) {
        if(numbers == null){
            throw new RuntimeException("参数错误");
        }

        // 用来保存数组中所有数的 二进制 位数和
        int[] bitSum = new int[32];

        for(int i = 0; i < numbers.length; ++i) {
            int bitMask = 1;
            for(int j = 31; j >= 0 ; --j) {
                int bit = numbers[i] & bitMask;
                if(bit != 0) {
                    bitSum[j] += 1;
                    bitMask = bitMask << 1;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < 32; ++i) {
            result = result << 1;
            result += bitSum[i]  % 3;
        }


        return result;
    }


}
