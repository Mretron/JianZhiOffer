package com.zzj.code.algorithm;

/**
 * @author etron
 * @date 2019/11/12 19:28
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] data ={2,12,34,34,56,623,21 };
        quickSort(data, 0 , data.length - 1);
        for(int temp : data) {
            System.out.print(temp + " ");
        }
    }

    public static void quickSort(int[] data, int start, int end) {
        if(data == null || start == end) {
            return;
        }
        // 先随机快排一次
        int index = partition(data, start, end);
        // 这时已经将data分为两部分，比data[index] 大小两部分
        if(index > start) {
            // 快排小的左部分
            quickSort(data, start, index - 1);
        }
        if(index < end) {
            // 快排大的右部分
            quickSort(data, index + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {


        // 随机选择一个，但是咱们这里就试着默认第一个
        int index = start;
        // 将这个划分点首先放到最后一位
        swap(data, index, end);

        // 标记过程中是否应该去交换
        int small = start - 1;

        for(int i = start; i < end ; i++) {
            // 开始遍历
            if(data[i] < data[end]) {
                // 如果确实当前下标的数比咱们选定的数小，那么small ++
                small ++;
                // 确实小意味着small == i
                if(small != i) {
                    // 进入到这里意味着之前有比 选定的数更大的， 使得small 没有++
                    // 而且当前下标i的值 更小，就需要去交换第一个更大的
                    // 这时small就代表着第一个更大的数
                    swap(data, i, small);
                }
            }
        }

        // 直到最后，small 再进行++
        // small就代表着第一个比data[end] 大的下标
        ++small;
        // 最后再交换，就实现了左边都更小，右边都更大
        swap(data, small, end);
        return small;
    }

    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
