package com.zzj.code.chapter6.q7;

/**
 * @author etron
 * @date 2019/11/28 13:15
 */
public class Test {

    /**
     * 分别找出这两个数
     */
    private static int num1 = 0;
    private static int num2 = 0;

    private static void FindNumsAppearOnce(int[] data) {
        if(data == null) {
            return;
        }

        int resultExclusiveOR = 0;

        // 经过所有的异或，出现两次的数都被相除
        // 最后只是这两个数异或的结果
        for(int i = 0; i < data.length ; i++) {
            resultExclusiveOR ^= data[i];
        }

        // 根据从右往左的第一个1的位置将原数组分别两组
        int indexOf1 = FindFirstBitIs1(resultExclusiveOR);

        for(int j = 0; j < data.length ; ++j) {
            if(IsBit1(data[j], indexOf1)) {
                num1 ^= data[j];
            } else {
                num2 ^= data[j];
            }
        }

    }

    /**
     * 用来在整数 num 的 二进制表示中找到最右边是1的位
     * @param num
     * @return
     */
    private static int FindFirstBitIs1(int num) {
        int indexBit = 0;
        while(((num & 1) == 0) && (indexBit < 32)) {
            num = num >> 1;
            ++ indexBit;
        }
        return indexBit;
    }

    /**
     * 判断在num 的二进制表示中从右边数起的indexBit位是不是1
     * @param num
     * @param indexBit
     * @return
     */
    private static boolean IsBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 0 ? false : true;
    }

}
