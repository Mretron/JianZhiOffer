package com.zzj.code.chapter6.q20;

/**
 * @author etron
 * @date 2019/11/28 18:07
 */
public class Test {
    private static int Add(int num1, int num2) {

        int sum, carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);

        return num1;
    }
}
