package com.zzj.code.chapter3.q3;

public class Test {

    private static void DeleteNode(ListNode pListHead, ListNode pToBeDeleted) {
        if(pListHead == null || pToBeDeleted == null) {
            return;
        }

        // 要删除的节点不是尾节点
        if(pToBeDeleted.m_pNext != null) {
            ListNode pNext = pToBeDeleted.m_pNext;
            pToBeDeleted.m_nValue = pNext.m_nValue;
            pToBeDeleted.m_pNext = pNext.m_pNext;

            pNext = null;
        } else if(pListHead == pToBeDeleted) {
            // 链表只有一个节点，删除头节点（也是尾节点）
            pToBeDeleted = null;
            pListHead = null;
        } else {
            // 链表中有多个节点，删除尾节点
            ListNode pNode = pListHead;
            while(pNode.m_pNext != pToBeDeleted) {
                pNode = pNode.m_pNext;
            }

            pNode.m_pNext = null;
            pToBeDeleted = null;
        }



    }
}
