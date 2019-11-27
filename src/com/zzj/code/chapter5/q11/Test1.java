package com.zzj.code.chapter5.q11;

/**
 * @author etron
 * @date 2019/11/26 13:44
 */
public class Test1 {
    public static int GetUglyNumber_Solution2(int index) {
        if(index <= 0) {
            return 0;
        }

        // 开指定大小的数组
        int[] pUglyNumbers = new int[index];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;

        while(nextUglyIndex < index) {
            int min = Min(pUglyNumbers[index_2] * 2, pUglyNumbers[index_3] * 3, pUglyNumbers[index_5] * 5);
            pUglyNumbers[nextUglyIndex] = min;

            while(pUglyNumbers[index_2] * 2 <= pUglyNumbers[nextUglyIndex]) {
                ++index_2;
            }
            while(pUglyNumbers[index_3] * 3 <= pUglyNumbers[nextUglyIndex]) {
                ++index_3;
            }
            while(pUglyNumbers[index_5] * 5 <= pUglyNumbers[nextUglyIndex]) {
                ++index_5;
            }
            ++nextUglyIndex;
        }
        int ugly = pUglyNumbers[nextUglyIndex - 1];
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
