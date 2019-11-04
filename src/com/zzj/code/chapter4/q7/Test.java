package com.zzj.code.chapter4.q7;

import java.util.LinkedList;

/**
 * @author etron
 * @date 2019/11/4 11:25
 */
public class Test {
    private static void Print(BinaryTreeNode pRoot) {
        if(pRoot == null) {
            return;
        }
        LinkedList<BinaryTreeNode>[] levels = new LinkedList[2];
        int current = 0;
        int next = 1;

        levels[current].push(pRoot);
        while(!levels[0].isEmpty() || !levels[1].isEmpty()) {
            BinaryTreeNode pNode = levels[current].pop();
            System.out.print(pNode.m_nValue + " ");

            if(current == 0) {
                if(pNode.m_pLeft != null) {
                    levels[next].push(pNode.m_pLeft);
                }
                if(pNode.m_pRight != null) {
                    levels[next].push(pNode.m_pRight);
                }
            } else {
                if(pNode.m_pRight != null) {
                    levels[next].push(pNode.m_pRight);
                }
                if(pNode.m_pLeft != null) {
                    levels[next].push(pNode.m_pLeft);
                }
            }

            if(levels[current].isEmpty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }
}
