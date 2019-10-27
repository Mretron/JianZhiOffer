package com.zzj.code.chapter2.q11;

public class MyTest {


    private static int Half_TrueMin(int[] data, int length) {


        if(data == null || length < 0) {
            throw new RuntimeException("参数错误");
        }

        int index1 = 0;
        int index2 = length - 1;
        int indexMid = index1;

        while(data[index1] >= data[index2]) {
            if(index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index2 + index1) / 2;
            if(data[indexMid] >= data[index2]) {
                index1 = indexMid;
            } else if(data[indexMid] <= data[index2]) {
                index2 = indexMid;
            }

        }
        return data[indexMid];

    }

    /**
     * 当index1、index2、indexMid都相等上面的方法无法成功
     * 如{1,0,1,1,1}
     * 这种情况就使用顺序查找好了
     * @param numbers
     * @param length
     * @return
     */
    private static int Ture_Min(int[] numbers, int length) {
        if(numbers == null || length < 0) {
            throw new RuntimeException("参数错误");
        }

        int index1 = 0;
        int index2 = length - 1;
        int indexMid = index1;
        while(numbers[index1] >= numbers[index2]) {
            if(index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2)/2;

            // 如果下标为inde,index2,indexMid指向的三个数字相等，
            // 则只能顺序查找
            if(numbers[index1] == numbers[index2] && numbers[index2] == numbers[indexMid]) {
                //顺序查找
                return MinInOrder(numbers, index1, index2);
            }

            if(numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if(numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

    /**
     * 顺序查找
     * @param numbers
     * @param index1
     * @param index2
     * @return
     */
    private static int MinInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for(int i = index1 + 1;i<=index2; i++) {
            if(result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] data = {3,4,5,1,2};
        int[] data2 = {1,0,1,1,1};
        System.out.println(Ture_Min(data2, data2.length));
    }
}
