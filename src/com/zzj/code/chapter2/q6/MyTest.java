package com.zzj.code.chapter2.q6;

public class MyTest {


    private static BinaryTreeNode Construct(int[] preOrder, int[] inOrder, int length) {
        if(preOrder == null || inOrder == null || length <=0 ) {
            throw new RuntimeException("参数出错");
        }

        return ConstructCore(preOrder, 0, preOrder.length - 1,
                             inOrder,   0,  inOrder.length - 1);
    }

    private static BinaryTreeNode ConstructCore(int[] preOrder, int startPreIndex, int endPreIndex,
                                                int[] inOrder , int startInIndex, int endInIndex) {

        // 拿到头节点的值,肯定是前序遍历第一个
        int rootValue = preOrder[startPreIndex];

        BinaryTreeNode root = new BinaryTreeNode(rootValue);

        // 判断是不是只有一个节点
        if(startPreIndex == endPreIndex) {
            if(startInIndex == endInIndex
                    && preOrder[startPreIndex] == inOrder[startInIndex]) {
                return root;
            } else {
                throw new RuntimeException("输入错误");
            }
        }


        // 已经在前序遍历中拿到头节点，下一步，找到中序遍历节点的位置
        int rootInIndex = startInIndex;

        while(rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            ++rootInIndex;
        }

        if(rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
            throw new RuntimeException("输入异常");
        }

        // 中序节点中根节点的位置 - 中序起点位置
        int leftLength = rootInIndex - startInIndex;
        //int leftLength = rootInIndex - startInIndex;

        // 计算前序中属于左子树的 尾节点下标
        int leftPreOrderEndIndex = startPreIndex + leftLength;

        if(leftLength > 0) {
            // 构建左子树
            root.leftNode = ConstructCore(preOrder, startPreIndex+1, leftPreOrderEndIndex,
                                          inOrder,  startInIndex, rootInIndex - 1);
        }


        if(leftLength < endPreIndex - startPreIndex) {
            // 构建右子树
            root.rightNode = ConstructCore(preOrder, leftPreOrderEndIndex + 1, endPreIndex,
                                            inOrder, rootInIndex + 1, endInIndex);
        }
        return root;
    }

    public static void printPreOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + " ");
        }
        if (root.leftNode != null) {
            printPreOrder(root.leftNode);
        }
        if (root.rightNode != null) {
            printPreOrder(root.rightNode);
        }
    }



    public static void main(String[] args) throws Exception{
        BinaryTreeNode test=new BinaryTreeNode();
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder  = {4,7,2,1,5,3,8,6};
        printPreOrder(Construct(preOrder, inOrder, preOrder.length));
    }
}
