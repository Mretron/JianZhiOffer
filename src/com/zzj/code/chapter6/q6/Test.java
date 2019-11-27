package com.zzj.code.chapter6.q6;

/**
 * @author etron
 * @date 2019/11/27 17:42
 */
public class Test {

    /**
     * 需要重复遍历节点多次的解法，简单但不足以打动面试官
     * @param pRoot
     * @return
     */
    private boolean IsBalanced(BinaryTreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }

        int left = TreeDepth(pRoot.m_pLeft);
        int right = TreeDepth(pRoot.m_pRight);
        int diff = left - right;
        if(diff > 1 || diff < -1) {
            return false;
        }

        return IsBalanced(pRoot.m_pLeft) && IsBalanced(pRoot.m_pRight);
    }

    private static int TreeDepth(BinaryTreeNode pRoot) {
        if(pRoot == null) {
            return 0;
        }

        int nLeft = TreeDepth(pRoot.m_pLeft);
        int nRight = TreeDepth(pRoot.m_pRight);

        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }
}
