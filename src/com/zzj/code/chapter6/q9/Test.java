package com.zzj.code.chapter6.q9;

/**
 * @author etron
 * @date 2019/11/28 13:37
 */
public class Test {

    private static int num1 = 0;
    private static int num2 = 0;
    private static boolean FindNumbersWithSum(int[] data, int sum) {
        boolean found = false;
        if(data == null) {
            return false;
        }

        int ahead = data.length - 1;
        int behind = 0;

        while(ahead > behind) {
            int curSum = data[ahead] + data[behind];

            if(curSum == sum) {
                num1 = data[behind];
                num2 = data[ahead];
                found = true;
                break;
            } else if(curSum > sum){
                ahead --;
            } else {
                behind++;
            }
        }
        return found;
    }
}
