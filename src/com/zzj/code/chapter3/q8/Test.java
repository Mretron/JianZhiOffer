package com.zzj.code.chapter3.q8;

public class Test {
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
