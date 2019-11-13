package com.zzj.code.chapter5.q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author etron
 * @date 2019/11/13 22:19
 */
public class Test1 {


    /**
     * 适合海量数据的最大堆O(nlogk)
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_2(int [] input, int k) {
        // 由于本题需要返回ArrayList<Integer>，所以新建之
        ArrayList<Integer> res = new ArrayList<>();
        // 几种特殊情况
        if (k > input.length|| k == 0) {
            return res;
        }
        // 构造优先队列，排序方法是自然数顺序的逆序，所以是个最大堆，这样这个堆的堆顶就是所有数中的最大数
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            // 最大堆内数字个数少于k，一直添加到k个
            if (queue.size() < k) {
                queue.add(input[i]);
            }
            else {
                // 若堆内最大的数字大于数组中的数字，则将数字出堆，并放入这个小的数
                if (input[i] < queue.peek()) {
                    queue.remove();
                    queue.add(input[i]);
                }
            }
        }

        // 结束上面循环后，堆内就是最小的k个数
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        Test1 solution_40 = new Test1();
        System.out.println(solution_40.GetLeastNumbers_Solution_2(a, 4));
    }

}
