package com.zzj.code.chapter2.q4;

public class Test {

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

    private static void ReplaceBlank(char[] string, int length) {
        if(string == null || length <=0) {
            throw new RuntimeException("形参异常");
        }

        // originalLength 为字符串string 的实际长度
        int originalLength = 0;
        int numberOfBlank = 0;
        int i = 1;
        while(i != temp.length) {
            if(temp[i-1] == ' ') {
                ++numberOfBlank;
            }
            ++originalLength;
            ++i;
        }

        // newLength 为把空格替换成‘%20’之后的长度
        int newLength =  originalLength + numberOfBlank*2;
        if(newLength > length) {
            return;
        }

        int indexOfOriginal = originalLength;
        int indexOfNew = newLength;


        while(indexOfOriginal >=0 && indexOfNew > indexOfOriginal) {
            if(string[indexOfOriginal] == ' ') {
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
