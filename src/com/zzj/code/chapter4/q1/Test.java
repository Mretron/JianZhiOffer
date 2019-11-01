package com.zzj.code.chapter4.q1;

public class Test {
    private static void MirrorRecursivly(BinaryTreeNode pNode) {
        if(pNode == null) {
            return;
        }

        if(pNode.m_pLeft == null && pNode.m_pRight == null) {
            return;
        }

        BinaryTreeNode pTemp = pNode.m_pLeft;
        pNode.m_pLeft = pNode.m_pRight;
        pNode.m_pRight = pTemp;

        if(pNode.m_pLeft != null) {
            MirrorRecursivly(pNode.m_pLeft);
        }

        if(pNode.m_pRight != null) {
            MirrorRecursivly(pNode.m_pRight);
        }
    }
}
