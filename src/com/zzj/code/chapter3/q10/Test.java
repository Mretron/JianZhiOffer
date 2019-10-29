package com.zzj.code.chapter3.q10;

public class Test {

    private static boolean HasSubtree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {

        boolean result = false;

        if(pRoot1 != null && pRoot2 != null) {
            // 由此开启第一个节点 的比较
            if(Equal(pRoot1.m_dbValue, pRoot2.m_dbValue)) {
                result = DoesTree1HaveTree2(pRoot1, pRoot2);
            }
            // 遍历所有的节点，直到出现一个result = true 就可以停止
            if(!result) {
                result = HasSubtree(pRoot1.m_pLeft, pRoot2);
            }
            if(!result) {
                result = HasSubtree(pRoot1.m_pRight, pRoot2);
            }
        }
        return result;
    }

    private static boolean DoesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if(pRoot2 == null) {
            return true;
        }
        if(pRoot1 == null) {
            return false;
        }

        if(!Equal(pRoot1.m_dbValue, pRoot2.m_dbValue)) {
            return false;
        }

        return DoesTree1HaveTree2(pRoot1.m_pLeft, pRoot2.m_pLeft) && DoesTree1HaveTree2(pRoot1.m_pRight, pRoot2.m_pRight);
    }

    private static boolean Equal(double num1, double num2) {
        if((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
            return true;
        } else{
            return false;
        }
    }
}
