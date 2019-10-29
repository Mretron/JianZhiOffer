package com.zzj.code.chapter3.q6;

public class Test {

    private static ListNode FindKthToTail(ListNode pListHead, int k) {
        if(pListHead == null || k == 0) {
            return null;
        }

        ListNode pAhead = pListHead;
        ListNode pBehind = null;

        // 因为头节点就用于存数据
        // 先让pAhead走k-1步
        for(int i = 0; i < k - 1; ++i) {
            if(pAhead.m_pNext != null) {
                pAhead = pAhead.m_pNext;
            } else {
                return null;
            }
        }

        // 这时pAhead已经提前走了K-1步了
        // 让pBehind从头开始和pAhead同步一步步走
        // 当pAhead到链表末端时，pBehind就是倒数第K个节点
        pBehind = pListHead;
        while(pAhead.m_pNext != null) {
            pAhead = pAhead.m_pNext;
            pBehind = pBehind.m_pNext;
        }

        return pBehind;
    }
}
