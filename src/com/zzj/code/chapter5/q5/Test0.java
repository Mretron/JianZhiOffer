package com.zzj.code.chapter5.q5;

/**
 * @author etron
 * @date 2019/11/18 18:50
 */
public class Test0 {

    /**
     * 这种思路很简单，遍历每一个数
     * 通过取余去判断这一位是不是1
     * @param n
     * @return
     */
    private static int numberOf1Between1AndN(int n) {
        if(n<0) {
            return 0;
        }
        int count = 0;

        for(int i = 1;i <= n; i++) {
            count += numberOf1(i);
        }
        return count;
    }

    private static int numberOf1(int n) {
        int count = 0;
        while( n > 0) {
            if( n % 10 == 1) {
                ++count;
            }
            n = n / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(21354));
    }
}
