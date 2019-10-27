package com.zzj.code.chapter2.q11;

public class Test {


    /**
     * 这个代码并非完美，{1,0,1,1,1}和{1,1,1,0,1}都可以看成{0,1,1,1,1}的旋转
     * @param numbers
     * @param length
     * @return
     */
    private static int  Min(int[] numbers, int length) {
        if(numbers == null || length <=0) {
            throw new RuntimeException("Invalid parameters");
        }

        // 指向前一半的数组
        int index1 = 0;
        // 指向后一半的数组
        int index2 = length - 1;
        // 当前时刻中间值
        // 如果旋转了0个，则直接返回index1
        int indexMid = index1;

        // 因为是有序的旋转数组
        // 所以分为两半后，前一半一定会比后一半大，最小值自然就在临界点
        // 所以咱们用两个指针：一个指向前面一半，一个指向后面一半
        // 通过计算中间下边的值，如果比前指针大，说明临界点在后面，这个中间值属于前一半数组
        // 如果这个值比前指针小，说明临界点在前面，这个中间值属于后一半的数组（不一定就是临界值）
        while(numbers[index1] >= numbers[index2]) {
            // 如果紧挨，则说明找到了临界值，也就是我们想要的最小值
            if(index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            // 没有找到，则根据比较缩小范围
            indexMid = (index1 + index2) / 2 ;
            if(numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if(numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }

        return numbers[indexMid];
    }

    public static void main(String[] args) {
        int[] data = {3,4,5,1,2};
        System.out.println(Min(data, data.length));
    }


}
