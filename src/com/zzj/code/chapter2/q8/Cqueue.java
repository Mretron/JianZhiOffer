package com.zzj.code.chapter2.q8;

import java.util.LinkedList;

public class Cqueue<T> {

    private LinkedList<T> stack1;
    private LinkedList<T> stack2;

    public void appendTail(T element){
        stack1.push(element);
    }


    public T deleteHead(){

        if(stack2.size() <= 0) {
            while(stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }

        if(stack2.size() == 0) {
            throw new RuntimeException("队列为空");
        }
        T head = stack2.pop();

        return head;
    }
}
