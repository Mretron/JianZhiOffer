package com.zzj.code.chapter6.q6;

/**
 * @author etron
 * @date 2019/11/27 17:45
 */
public class Test1 {

    /**
     * 每个节点只遍历一次的解法，正是面试官喜欢的
     * @param pRoot
     * @param pDepth
     * @return
     */
    private static boolean IsBalanced(BinaryTreeNode pRoot, int pDepth) {
        if(pRoot == null) {
            pDepth = 0;
            return true;
        }

        int left = 0,right = 0;
        if(IsBalanced(pRoot.m_pLeft, left)
            && IsBalanced(pRoot.m_pRight, right)) {
            int diff = left - right;
            if(diff <= 1 && diff >= -1) {
                pDepth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

    private static boolean IsBalanced(BinaryTreeNode pRoot) {
        int dept = 0;
        return IsBalanced(pRoot, dept);
    }
}
