package com.zzj.code.chapter3.q4;

public class Test {
    private static void DeleteDuplication(ListNode pHead) {
        if(pHead == null ) {
            return;
        }

        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while(pNode != null) {
            ListNode pNext = pNode.m_pNext;
            boolean needDelete = false;
            if(pNext != null && pNext.m_nValue == pNode.m_nValue) {
                needDelete = true;
            }
            if(!needDelete) {
                pPreNode = pNode;
                pNode = pNode.m_pNext;
            } else {
                int value = pNode.m_nValue;
                ListNode pToBeDel = pNode;
                while(pToBeDel != null && pToBeDel.m_nValue == value) {
                    pNext = pToBeDel.m_pNext;
                    pToBeDel = null;
                    pToBeDel = pNext;
                }
                if(pPreNode == null) {
                    pHead = pNext;
                } else {
                    pPreNode.m_pNext = pNext;
                }
                pNode = pNext;
            }
        }
    }
}
