## 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，输入前序遍历序列{1,2,4,7,3,5,6,8}
和中序遍历序列{4,7,2,1,5,3,8,6}
则重建出来
            1
        2           3
    4           5         6  
        7               8
        

二叉树节点的定义如下：
```java
class BinaryTreeNode{
    int m_nValue;
    BinaryTreeNode  m_pLeft;
    BinaryTreeNode  m_pRight;
}
```