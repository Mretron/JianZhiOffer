package com.zzj.code.chapter6.q13;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author etron
 * @date 2019/11/28 14:46
 */
public class Test {

    private static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        // 排除特殊情况，窗口的长度为0
        if(size == 0) {
            return result;
        }

        // 滑动窗口最左边数的index
        int begin;
        // 建立一个双端队列
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < num.length; i++) {
            // begin是窗口起始位置
            begin = i - size + 1;

            // 队列空，直接加入
            if(q.isEmpty()) {
                q.add(i);
            } else if(begin > q.peekFirst()) {
                // 若队列最左边值已经不在窗口内，直接删除
                q.pollFirst();
            }

            // 从队尾开始比较，把所有比它小的值丢掉
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i]) {
                q.pollLast();
            }
            // 随后再把它放进去
            q.add(i);

            // 若窗口起始位置在数组的0位置上或者之后（窗口是完整大小的），才计算窗口的有效最大值
            if(begin >= 0) {
                // 永远是队列最左边最大，加入结果集
                result.add(num[q.peekFirst()]);
            }
        }
        return result;
    }
}
