package com.zzj.code.chapter2.q15;

public class Test {

    /**
     * 可能引起死循环的解法
     * 没有考虑到补码
     * @param n
     * @return
     */
    private static int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            if((n&1) != 0) {
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 常规解法
     * 但是因为int是32位，所以需要循环32次
     * @param n
     * @return
     */
    private static int NumberOf2(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0) {
            if((n&flag) != 0) {
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 能给面试官带来惊喜的解法
     * 有多少个1进行多少次
     * @param n
     * @return
     */
    private static int NumberOf3(int n) {
        int count = 0;

        while(n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
