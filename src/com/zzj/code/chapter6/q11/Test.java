package com.zzj.code.chapter6.q11;

/**
 * @author etron
 * @date 2019/11/28 14:00
 */
public class Test {

    private static String reverse(String str) {
        char[] array = str.toCharArray();
        for(int i = 0; i < (array.length) / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-i-1] = temp;
        }
        return String.valueOf(array);
    }

    private static void reverseSentence(String sentence) {
        if(sentence == null) {
            return;
        }
        String sentenceReverse = reverse(sentence);
        String[] splitStrings = sentenceReverse.split(" ");
        String resultBuffer = "";
        for(String s : splitStrings) {
            resultBuffer = resultBuffer + reverse(s) + " ";
        }
        System.out.println(resultBuffer);
    }
}
