package com.zzj.code.chapter5.q11;

/**
 * @author etron
 * @date 2019/11/26 13:44
 */
public class Test1 {
    private static int GetUglyNumber_Solution2(int index) {
        if(index <= 0) {
            return 0;
        }

        // 开指定大小的数组
        int[] pUglyNumbers = new int[index];
        // 将第一个丑数赋值给1
        pUglyNumbers[0] = 1;
        // 时刻记录下一个丑数的下标
        int nextUglyIndex = 1;

        // 分别代表丑数乘以2,3,5
        int[] pMultiply2 = pUglyNumbers;
        int[] pMultiply3 = pUglyNumbers;
        int[] pMultiply5 = pUglyNumbers;
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        while(nextUglyIndex < index) {
            int min = Min(pMultiply2[index_2] * 2, pMultiply3[index_3] * 3, pMultiply5[index_5] * 5);
            pUglyNumbers[nextUglyIndex] = min;

            while(pMultiply2[index_2] * 2 <= pUglyNumbers[nextUglyIndex]) {
                ++ index_2;
            }
            while(pMultiply3[index_3] * 3 <= pUglyNumbers[nextUglyIndex]) {
                ++ index_3;
            }
            while(pMultiply5[index_5] * 5 <= pUglyNumbers[nextUglyIndex]) {
                ++ index_5;
            }

            ++ nextUglyIndex;
        }

        int ugly = pUglyNumbers[nextUglyIndex - 1];
        pUglyNumbers = null;
        return ugly;
    }

    private static int Min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution2(4));
    }
}
