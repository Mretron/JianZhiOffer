package com.zzj.code.chapter2.q1;

public class MyTest {
    public static int duplicate = 0;
    public static int numbers[] = {2,3,1,0,2,5,3};

    public static void main(String[] args) {
        if(duplicate(numbers,numbers.length)){
            System.out.println(duplicate);
        }
    }

    public static boolean duplicate(int[] numbers, int length) {
        if(numbers == null || length <= 0) {
            return false;
        }

        // 判断所有数都在题目规定范围内
        for(int i = 0;i < length ; i++) {
            if(numbers[i] > length - 1 || numbers[i] < 0) {
                return false;
            }
        }

        for(int i = 0; i < length ; i++) {
            // 当进入这个循环
            // 则意味着要么有重复的
            // 要么下标位置不对应
            while(numbers[i] != i) {
                // 下标不对应，但是已经存在该下标的数
                // 说明找到重复的数
                if(numbers[i] == numbers[numbers[i]]) {
                    duplicate = numbers[i];
                    return true;
                }

                // 没有，则交换到正确的位置
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

}
