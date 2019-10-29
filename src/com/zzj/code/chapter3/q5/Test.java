package com.zzj.code.chapter3.q5;

public class Test {

    private static void Reorder(int[] pData, int length) {
        if(pData == null || length == 0) {
            return;
        }

        int pBegin = 0;
        int pEnd = length - 1;

        while(pBegin < pEnd) {
            // 向后移动pBegin,直到它指向偶数
            // 偶数与0x1 相与都是 0 比如：10,100000,1000 & 0x1 = 0
            // 奇数的二进制末尾都是1，所以与0x1相与，只要结果不为0都为奇数
            while(pBegin < pEnd && (pData[pBegin] & 0x1) != 0) {
                pBegin ++;
            }

            // 向前移动pEnd,直到它指向奇数
            while(pBegin < pEnd && (pData[pEnd] & 0x1) == 0) {
                pEnd --;
            }

            if(pBegin < pEnd) {
                int temp = pData[pBegin];
                pData[pBegin] = pData[pEnd];
                pData[pEnd] = temp;
            }
        }
    }
}
