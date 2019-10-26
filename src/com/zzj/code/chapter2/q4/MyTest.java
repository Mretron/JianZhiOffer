package com.zzj.code.chapter2.q4;

public class MyTest {

    /**
     * 需要替换空格为%20字符数组
     */
    private static char[] temp = "We are happy.".toCharArray();

    /**
     * 用来保存结果的字符数组
     */
    private static char[] string = new char[19];

    public static void main(String[] args) {

        for(int i=0; i<temp.length; i++) {
            string[i] = temp[i];
        }
        System.out.println(temp);
        ReplaceBlank(string, string.length);
        System.out.println(string);
    }

    private static void ReplaceBlank(char[] string, int length){
        if(string == null || length <0) {
            throw new RuntimeException("形参出错");
        }

        int originalLength = 0;
        int numberOfBlank = 0;
        int i = 1;
        while(i!=temp.length) {
            ++originalLength;
            if(temp[i-1] == ' ') {
                ++numberOfBlank;
            }
            ++i;
        }
        int newLength = originalLength + 2*numberOfBlank;
        if(newLength > string.length){
            return;
        }
        int indexOfOriginal = originalLength;
        int indexOfNew = newLength;

        while(indexOfOriginal>=0&&indexOfOriginal < indexOfNew) {
            if(string[indexOfOriginal] == ' '){
                string[indexOfNew--] = '0';
                string[indexOfNew--] = '2';
                string[indexOfNew--] = '%';

            } else {
               string[indexOfNew--] = string[indexOfOriginal];
            }
            --indexOfOriginal;
        }

    }



}
