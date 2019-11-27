package com.zzj.code.chapter6.q17;

/**
 * @author etron
 * @date 2019/11/28 17:57
 */
public class Test1 {


    private static int LastRemaining(int n, int m) {
        if(n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for(int i = 2; i<=n; i++) {
            last = (last + m) %i;
        }
        return last;
    }
}
