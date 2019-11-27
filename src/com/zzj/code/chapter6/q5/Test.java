package com.zzj.code.chapter6.q5;

/**
 * @author etron
 * @date 2019/11/27 17:38
 */
public class Test {

    private static int TreeDepth(BinaryTreeNode pRoot) {
        if(pRoot == null) {
            return 0;
        }

        int nLeft = TreeDepth(pRoot.m_pLeft);
        int nRight = TreeDepth(pRoot.m_pRight);

        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }
}
