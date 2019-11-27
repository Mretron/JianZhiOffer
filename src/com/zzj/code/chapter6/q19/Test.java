package com.zzj.code.chapter6.q19;

/**
 * @author etron
 * @date 2019/11/28 18:06
 */
public class Test {

    private static int Sum_Solution(int n) {
        int sum = n;
        boolean s = ((n > 0) && ((sum += Sum_Solution(n - 1)) > 0));
        return sum;
    }
}
