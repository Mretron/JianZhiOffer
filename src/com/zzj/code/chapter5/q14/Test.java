package com.zzj.code.chapter5.q14;

/**
 * @author etron
 * @date 2019/11/26 19:13
 */
public class Test {
    private static int InversePairs(int[] data) {
        if(data == null) {
            return 0;
        }
        int[] copy = new int[data.length];
        for(int i = 0 ; i <data.length; i++) {
            copy[i] = data[i];
        }

        int count = InversePairsCore(data, copy, 0, data.length - 1);
        copy = null;
        return count;
    }

    private static int InversePairsCore(int[] data, int[] copy, int start, int end) {
        if(start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;

        int left = InversePairsCore(copy, data, start, start + length);
        int right = InversePairsCore(copy, data, start + length + 1, end);

        // i 初始化为前半段最后一个数字的下标
        int i = start + length;
        // j 初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + length + 1) {
            if(data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        for(;i >= start; --i) {
            copy[indexCopy--] = data[i];
        }

        for(;j >= start + length + 1; --j) {
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }
}
