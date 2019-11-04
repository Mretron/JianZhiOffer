package com.zzj.code.chapter4.q6;

import java.util.LinkedList;

/**
 * @author etron
 * @date 2019/11/4 11:17
 */
public class Test {
    private static void Pint(BinaryTreeNode pRoot) {
        if(pRoot == null) {
            return;
        }

        LinkedList<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(pRoot);

        int nextLevel = 0;
        int toBePrinted =  1;
        while(!nodes.isEmpty()) {
            BinaryTreeNode pNode = nodes.poll();
            System.out.print(pNode.m_nValue + " ");
            if(pNode.m_pLeft != null) {
                nodes.add(pNode.m_pLeft);
                ++nextLevel;
            }
            if(pNode.m_pRight != null) {
                nodes.add(pNode.m_pRight);
                ++nextLevel;
            }
            nodes.poll();
            --toBePrinted;
            if(toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
