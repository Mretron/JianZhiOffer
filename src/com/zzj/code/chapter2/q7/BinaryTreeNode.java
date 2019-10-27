package com.zzj.code.chapter2.q7;

public class BinaryTreeNode {
    int value;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;
    BinaryTreeNode fatherNode;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int m_nValue) {
        this.value = m_nValue;
        this.leftNode  = null;
        this.rightNode = null;
        this.fatherNode = null;
    }
}
