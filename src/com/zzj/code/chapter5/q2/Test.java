package com.zzj.code.chapter5.q2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author etron
 * @date 2019/11/13 11:31
 */
public class Test {
    /**
     *  PriorityQueue默认使用小顶堆实现
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /**
     * 大顶堆
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    public void Insert(Integer num) {
        if(((minHeap.size() + maxHeap.size()) & 1) == 0){
            // 偶数时，下个数字加入小顶堆
            if(!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            // 奇数时，下一个数字放入大顶堆
            if(!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if((minHeap.size()+maxHeap.size())==0) {
            throw new RuntimeException();
        }
        double median;
        if((minHeap.size()+maxHeap.size()&1)==0){
            median=(maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            median=minHeap.peek();
        }
        return median;
    }

}
