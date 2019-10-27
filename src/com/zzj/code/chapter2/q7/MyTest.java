package com.zzj.code.chapter2.q7;

public class MyTest {
    private static BinaryTreeNode GetNext(BinaryTreeNode pNode) {
        if(pNode == null) {
            return null;
        }
        BinaryTreeNode next = null;
        if(pNode.rightNode != null) {
            BinaryTreeNode pRight = pNode.rightNode;
            while(pRight.rightNode != null) {
                pRight = pRight.rightNode;
            }
            next = pRight;
        } else if(pNode.fatherNode != null) {
            BinaryTreeNode pCurrent = pNode;
            BinaryTreeNode pParent = pNode.fatherNode;
            while(pParent != null && pCurrent == pParent.rightNode) {
                pCurrent = pParent;
                pParent = pParent.fatherNode;
            }
            next = pParent;
        }
        return next;
    }
}
