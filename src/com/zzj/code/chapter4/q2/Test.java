package com.zzj.code.chapter4.q2;

public class Test {

    private static boolean isSymmetrical(BinaryTreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private static boolean isSymmetrical(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null) {
            return true;
        }

        if(pRoot1 == null && pRoot2 == null) {
            return false;
        }

        if(pRoot1.m_nValue != pRoot2.m_nValue) {
            return false;
        }

        return isSymmetrical(pRoot1.m_pLeft, pRoot2.m_pRight)
                && isSymmetrical(pRoot1.m_pRight, pRoot2.m_pLeft);
    }
}
