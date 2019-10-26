package com.zzj.code.chapter2.q5;

import java.util.LinkedList;

public class Test {

    /**
     * 使用栈
     * @param pHead
     */
    private static void PrintListReversingly_Iteratively(ListNode pHead) {
        LinkedList<ListNode> nodes = new LinkedList<>();

        ListNode pNode = pHead;
        while(pNode != null) {
            nodes.push(pNode);
            pNode = pNode.m_pNext;
        }

        while(!nodes.isEmpty()) {
            pNode = nodes.pop();
            System.out.print(pNode.m_nKey + " ");
        }
    }

    /**
     * 递归
     * @param pHead
     */
    private static void PrintListReversingly_Recursively(ListNode pHead) {
        if(pHead != null) {
            if(pHead.m_pNext != null) {
                PrintListReversingly_Recursively(pHead.m_pNext);
            }
            System.out.print(pHead.m_nKey + " ");
        }
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode();
        pHead.m_nKey = 1;
        pHead.m_pNext = null;

        ListNode pr = pHead;
        ListNode p = null;

        // 创建一条链表1 2 3 4 5
        for(int i = 2; i <= 5; i++) {
            p = new ListNode();
            p.m_nKey = i;
            p.m_pNext = null;

            pr.m_pNext = p;
            pr = pr.m_pNext;
        }

        pr = pHead;
        while(pr!=null) {
            System.out.print(pr.m_nKey + " ");
            pr = pr.m_pNext;
        }
        System.out.println();

        System.out.println("递归：");
        PrintListReversingly_Recursively(pHead);
        System.out.println();
        System.out.println("栈：");
        PrintListReversingly_Iteratively(pHead);

    }
}
