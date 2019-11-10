package com.zzj.code.chapter4.q9;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author etron
 * @date 2019/11/4 22:02
 */
public class Test {

    private static void FindPath(BinaryTreeNode pRoot, int expectedSum) {
        if(pRoot == null) {
            return;
        }
        LinkedList path = new LinkedList();
        int currentSum = 0;
        FindPath(pRoot, expectedSum, path, currentSum);
    }

    private static void FindPath(BinaryTreeNode pRoot,
                                 int expectedSum,
                                 LinkedList path,
                                 int currentSum) {
        currentSum += pRoot.m_nValue;
        path.push(pRoot.m_nValue);

        // 如果是叶节点，并且路径上节点值的和等于输入的值，
        // 则打印出这条路径
        boolean isLeaf = (pRoot.m_pLeft == null && pRoot.m_pRight == null);
        if(currentSum == expectedSum && isLeaf) {
            System.out.print("A path is found: ");
            Iterator iter = path.iterator();
            for(; iter.hasNext(); iter.next()) {
                System.out.print(iter);
            }
            System.out.println();
        }

        // 如果不是叶节点，则遍历它的子节点
        if(pRoot.m_pLeft != null) {
            FindPath(pRoot.m_pLeft, expectedSum, path, currentSum);
        }
        if(pRoot.m_pRight != null) {
            FindPath(pRoot.m_pRight, expectedSum, path, currentSum);
        }

        // 在返回父节点之前，在路径上删除当前节点
        path.pop();
    }
}
