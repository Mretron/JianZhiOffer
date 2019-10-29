package com.zzj.code.chapter3.q9;

public class Test {
    private static ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null) {
            return pHead2;
        } else if(pHead2 == null) {
            return pHead1;
        }

        ListNode pMergedHead = null;

        if(pMergedHead.m_nValue < pHead2.m_nValue) {
            pMergedHead = pHead1;
            pMergedHead.m_pNext = Merge(pHead1.m_pNext, pHead2);
        } else {
            pMergedHead = pHead2;
            pMergedHead.m_pNext = Merge(pHead1, pHead2.m_pNext);
        }
        return pMergedHead;
    }
}


