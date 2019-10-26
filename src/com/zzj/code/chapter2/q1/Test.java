package com.zzj.code.chapter2.q1;


public class Test {

    private static int duplicate = 0;
    private static int[] data = {2,3,1,0,2,5,3};

    public static void main(String[] args) {
        if(duplicate(data,data.length)) {
            System.out.println("重复的数字：" + duplicate);
        } else {
            System.out.println("无重复的数字");
        }

    }

    /**
     * 规则，在长度为n的数组中，与0~n-1的数字
     * 返回其中的一个重复数字即可
     * @param numbers
     * @param length
     * @return
     */
    public static boolean duplicate(int[] numbers, int length) {
        if(numbers == null || length <= 0) {
            return false;
        }

        for(int i = 0; i < length; i++) {
            if(numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        // 将数组中的数放到对应的下标位置上
        // 如首先判断numbers[0] 是不是等于 0
        // 如果不是，就把numbers[0] 放在对应的位置上
        // 如numbers[0]=2,就将numbers[0] 和 numbers[2] 交换
        for(int i = 0; i < length; i++) {
            // 这里numbers[i] != i
            // 就意味着可能的情况只有重复的数字或者没有被放在正确的位置
            while(numbers[i] != i) {
                // 这里就判断是否是已经有重复的数字了
                if(numbers[i] == numbers[numbers[i]]){
                    duplicate = numbers[i];
                    return true;
                }
                // 到这里说明是没有放在正确的位置
                // swap numbers[i] and numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

}
