package com.zzj.code.chapter4.q4;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author etron
 * @date 2019/11/4 11:01
 */
public class Test {
    public static boolean IsPopOrder(int[] pushOrder, int[] popOrder, int length)
    {
        boolean possible = false;

        if (pushOrder != null && popOrder != null && length > 0)
        {
            // 指向下一个要push的元素的index
            int nextPush = 0;
            // 指向下一个要pop的元素的index
            int nextPop = 0;
            // 指向popOrder的首个元素的index
            int pop = 0;
            // 指向pushOrder的首个元素的index
            int push = 0;

            Stack stackData = new Stack();
            while (nextPop - pop < length)
            {
                // 当辅助栈的栈顶元素不是要弹出的元素
                // 先压入一些数字入栈
                while (stackData.size() == 0 || (int)stackData.peek() != popOrder[nextPop])
                {
                    // 如果所有数字都压入辅助栈了，退出循环
                    if (nextPush - push == length)
                    {
                        break;
                    }

                    stackData.push(pushOrder[nextPush]);
                    nextPush++;
                }

                // 说明没有匹配成功
                if ((int)stackData.peek() != popOrder[nextPop])
                {
                    break;
                }

                stackData.pop();
                nextPop++;
            }

            if (stackData.size() == 0 && nextPop - pop == length)
            {
                possible = true;
            }
        }

        return possible;
    }
}
