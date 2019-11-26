package com.zzj.code.chapter5.q13;

/**
 * @author etron
 * @date 2019/11/26 15:42
 */
public class Test {

    private int index;

    private int[] occurence;


    /**
     * 在构造函数中初始化成员变量
     */
    public Test() {
        index=0;
        occurence = new int[256];
        for(int i=0;i<256;i++) {
            occurence[i]=-1;
        }
    }

    public void insert(char ch) {

        if(occurence[(int)ch]==-1) {

            // 第一次出现
            occurence[(int)ch]=index;
        }else if(occurence[(int)ch]>=0) {

            // 已经出现过了
            occurence[(int)ch]=-2;
        }
        index++;
    }

    public char getFirst() {

        // 最大的Integer
        int minIndex = Integer.MAX_VALUE;
        char ch = '#';
        for(int i = 0; i < 256; i++) {

            if( occurence[i]>=0 && occurence[i] < minIndex ) {

                ch = (char) i;
                minIndex = occurence[i];

            }
        }
        return ch;
    }

}
