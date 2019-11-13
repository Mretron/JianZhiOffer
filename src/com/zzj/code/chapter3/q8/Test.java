package com.zzj.code.chapter3.q8;

public class Test {


    /**
     * 其实思想很简单
     * 假设新的链表为a,原来的链表为b
     * 思想就是不断从b断开一个节点
     * 将这个断开的节点作为a 的 新头节点，并且与之前已经连接的a 相连接即可
     * @param pHead
     * @return
     */
    private static ListNode ReverseLsit(ListNode pHead) {
        ListNode pReversedHead = null;
        ListNode pNode = pHead;
        ListNode pPrev = null;

        while(pNode != null) {
            ListNode pNext = pNode.m_pNext;

            if(pNext == null) {
                pReversedHead = pNode;
            }
            pNode.m_pNext = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }
}
