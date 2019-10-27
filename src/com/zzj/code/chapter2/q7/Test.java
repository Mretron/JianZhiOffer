package com.zzj.code.chapter2.q7;

public class Test {

    private static BinaryTreeNode GetNext(BinaryTreeNode pNode) {
        if(pNode == null) {
            return null;
        }

        BinaryTreeNode pNext = null;
        if(pNode.rightNode != null) {
            // 如果右节点不为空
            // 那么它的下一个节点一定在一直往下的右子节点
            BinaryTreeNode pRight = pNode.rightNode;
            while(pRight.rightNode != null) {
                pRight = pRight.rightNode;
            }
            pNext = pRight;
        } else if(pNode.fatherNode != null) {
            // 右子节点为空
            // 下一个节点一定是空，或者向上父节点（到左节点结束）
            BinaryTreeNode pCurrent = pNode;
            BinaryTreeNode pParent = pNode.fatherNode;
            // 保证current自己这个节点一定是父节点的右子节点
            while(pParent != null && pCurrent == pParent.rightNode) {
                pCurrent = pParent;
                pParent = pParent.fatherNode;
            }
            pNext = pParent;
        }
        return pNext;
    }


}
