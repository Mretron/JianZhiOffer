package com.zzj.code.chapter2.q2;

public class Test {

    /**
     * 长度为n+1,范围为{1~n}
     */
    private static int[] numbers = {5,3,2,1,4,6,7,5};

    public static void main(String[] args) {
        System.out.println(getDuplication(numbers, numbers.length));
    }

    private static int getDuplication(int[] numbers, int length) {
        if(numbers == null || length < 0) {
            throw new RuntimeException("传入的形参不符合规范");
        }

        // 根据题目，设置范围
        int start = 1;
        int end = length - 1;

        while(end >= start) {
            // 计算中间值
            int middle = ((end - start) >> 1 ) +start;

            int count = countRange(numbers, length, start, middle);

            // 查到只有一个数了,要么找到了，要么没有
            if(end == start) {
                if(count > 1) {
                    return start;
                }else {
                    break;
                }
            }

            if(count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] numbers, int length, int start, int end) {
        if(numbers == null) {
            throw new RuntimeException("传入的参数不符合规范");
        }

        int count = 0;
        for(int i = 0; i < length ; i++) {
            if(numbers[i] >= start && numbers[i] <=end) {
                ++count;
            }
        }
        return count;
    }
}
