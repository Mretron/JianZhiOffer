package com.zzj.code.chapter6.q4;

/**
 * @author etron
 * @date 2019/11/27 17:30
 */
public class Test {
    private static BinaryTreeNode KthNode(BinaryTreeNode pRoot, int k) {
        if(pRoot == null || k == 0) {
            return null;
        }

        return KthNodeCore(pRoot, k);
    }

    private static BinaryTreeNode KthNodeCore(BinaryTreeNode pRoot, int k) {
        BinaryTreeNode target = null;

        if(pRoot.m_pLeft != null) {
            target = KthNodeCore(pRoot.m_pLeft, k);
        }

        if(target == null) {
            if(k == 1) {
                target = pRoot;
            }

            k--;
        }

        if(target == null && pRoot.m_pRight != null) {
            target = KthNodeCore(pRoot.m_pRight, k);
        }
        return target;
    }
}
