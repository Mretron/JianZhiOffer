package com.zzj.code.chapter5.q12;

/**
 * @author etron
 * @date 2019/11/26 14:03
 */
public class Test {

    private static int FirstNotRepeatingChar(String str) {
        if(str == null || str.equals("")) {
            return -1;
        }
        char[] chars = str.toCharArray();
        int[] arr = new int[65536];

        for(int i = 0 ; i < chars.length; ++i) {
            arr[hash(chars[i])] ++;
        }

        int index = 0;
        for(int i = 0 ; i < chars.length; i++) {
            if(arr[hash(chars[i])] == 1) {
                index = i;
                break;
            }
        }
        return index;

    }

    private static int hash(char c) {
        return c + 128;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("aabbcddeeff"));
    }
}
