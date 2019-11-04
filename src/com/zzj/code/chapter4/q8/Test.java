package com.zzj.code.chapter4.q8;

/**
 * @author etron
 * @date 2019/11/4 11:31
 */
public class Test {
     
    public boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence.length <= 0) {
            return false;
        } else {
            return compare(sequence,0,sequence.length-1);
        }

    }
    private boolean compare(int[]a,int start,int end) {

        //数组中只有一个元素，直接返回true
        if(start == end) {
            return true;
        }

        int i = start;
        while(a[i++] < a[end] && i < end) {
            ;//从数组开始位置开始比较，若是比根节点大，则停止遍历比较
        }

        //右子树的第一个节点在数组中的索引
        int j = i;
        while(a[j++] > a[end] && j < end) {
            ;//从比根元素大的第一个元素开始比较，直到数组的倒数第二个元素
        }

        if(j < end) {
            //若j不是数组的最后一个索引，则不是二叉搜索树
            return false;
        }

        if(i == start || i == end) {
            //若只有右子树或者只有左子树，数组除最后一个元素外都是其左孩子或者右孩子
            return compare(a,start,end-1);
        } else {
            //左右子树都不为空，递归判断左右子树是否全为搜索二叉树
            return (compare(a,start,i-1)&&compare(a,i,end-1));
        }
    }
}
