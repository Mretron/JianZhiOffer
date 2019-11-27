package com.zzj.code.chapter6.q12;

/**
 * @author etron
 * @date 2019/11/28 14:19
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

   private void leftRotateString(String sentence, int index) {

       if(sentence == null || index >sentence.length() || index <0) {
           return;
       }
       String[] splitStrings = {sentence.substring(0, index),sentence.substring(index, sentence.length())};
       String resultBuffer = "";
       for(int i =0;i<splitStrings.length;i++){
           splitStrings[i] =reverse(splitStrings[i]);
           resultBuffer+=splitStrings[i];
       }

       System.out.println(reverse(resultBuffer));
   }
}
