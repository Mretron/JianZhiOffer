package com.zzj.code.chapter6.q14;

import java.util.ArrayDeque;

/**
 * @author etron
 * @date 2019/11/28 15:08
 */
public class Test {


    private ArrayDeque<InternalData> data = new ArrayDeque<>();

    private ArrayDeque<InternalData> maximum = new ArrayDeque<>();


    private int curIndex;

    public void push_back(int number) {
        InternalData curData = new InternalData(number, curIndex);
        data.addLast(curData);

        while(!maximum.isEmpty() && maximum.getLast().number < number) {
            maximum.removeLast();
        }
        maximum.addLast(curData);
        curIndex++;
    }

    public void pop_front() {
        if(data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if(curData.index == maximum.getFirst().index) {
            maximum.removeFirst();
        }
    }

    public int max() {
        if(maximum == null) {
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return maximum.getFirst().number;
    }


    private class InternalData{
        int number;
        int index;

        public InternalData(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
}
