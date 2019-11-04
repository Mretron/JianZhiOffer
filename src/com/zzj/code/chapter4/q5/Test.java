package com.zzj.code.chapter4.q5;

import java.util.LinkedList;

/**
 * @author etron
 * @date 2019/11/4 11:10
 */
public class Test {

    private static  void PrintFromTopToBottom(BinaryTreeNode pTreeRoot){

        if(pTreeRoot == null) {
            return;
        }

        LinkedList<BinaryTreeNode> dequeTreeNode = new LinkedList<>();
        dequeTreeNode.add(pTreeRoot);
        while(dequeTreeNode.size() > 0) {
            BinaryTreeNode pNode = dequeTreeNode.poll();
            System.out.print(pNode.m_nValue + " ");

            if(pNode.m_pLeft != null) {
                dequeTreeNode.add(pNode.m_pLeft);
            }
            if(pNode.m_pRight != null) {
                dequeTreeNode.add(pNode.m_pRight);
            }
        }
    }

}
