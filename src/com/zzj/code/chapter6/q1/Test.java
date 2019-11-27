package com.zzj.code.chapter6.q1;

/**
 * @author etron
 * @date 2019/11/27 16:35
 */
public class Test {


    private static int GetNumberOfK(int[] data, int k) {
        int number = 0;

        if(data != null) {
            int first = GetFirst(data, k ,0 ,data.length - 1);
            int last = GetLast(data, k, 0 ,data.length - 1);

            if(first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
     }

    private static int GetFirst(int[] data, int k, int start, int end) {
        if(start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];

        if(middleData == k) {
            if((middleIndex > 0 && data[middleIndex - 1]!= k)
            || middleIndex == 0) {
                // 如果这个下标的前一个数不等于k，所以就是开头
                // 或者这个下标等于0，说明是数组中的开头
                // 以上两种情况都直接返回即可
                return middleIndex;
            } else {
                // 否则说明前一个也是一样的k
                // --即可,说不定前一个既是开头
                end = middleIndex - 1;
            }
        } else if(middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return GetFirst(data, k ,start, end);
    }

    private static int GetLast(int[] data, int k, int start, int end) {
        if(start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];

        if(middleData == k) {
            if((middleIndex < data.length - 1 && data[middleIndex + 1]!= k)
                    || middleIndex == data.length - 1) {
                return middleIndex;
            } else {
                // 否则说明前一个也是一样的k
                // --即可,说不定前一个既是开头
                start = middleIndex + 1;
            }
        } else if(middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return GetLast(data, k ,start, end);
    }


}
