package com.zzj.code.chapter2.q2;

public class MyTest {
    private static int[] numbers = {2,3,5,4,3,2,6,7};

    public static void main(String[] args) {
        System.out.println(getDuplication(numbers, numbers.length));
    }

    private static int getDuplication(int[] numbers, int length) {
        if(numbers == null || length < 0 ) {
            throw new RuntimeException("形参出错");
        }

        int start = 1;
        int end = length - 1;

        while(start <= end) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, middle);


            if(start == end) {
                if(count > 1) {
                    return start;
                }else {
                    break;
                }
            }

            if(count > (middle - start + 1)) {
                end = middle;
            }else {
                start = middle + 1;
            }
        }
        return -1;

    }

    private static int countRange(int[] numbers,int length, int start, int end) {
        if(numbers == null) {
            throw new RuntimeException("形参出错");
        }
        int count = 0;
        for(int i = 0; i<length ; i++) {
            if(numbers[i] >= start && numbers[i] <= end) {
                count ++;
            }
        }
        return count;
    }

}
