package com.zzj.code.chapter5.q15;

/**
 * @author etron
 * @date 2019/11/26 19:31
 */
public class Test {
    private static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 得到两个链表的长度
        int nLength1 = GetListLength(pHead1);
        int nLength2 = GetListLength(pHead2);
        // 得到长度差
        int nLengthDif = nLength1 - nLength2;

        ListNode pListHeadLong = pHead1;
        ListNode pListHeadShort = pHead2;
        if(nLength2 > nLength1) {
            pListHeadLong = pHead2;
            pListHeadShort = pHead1;
            nLengthDif = nLength2 - nLength1;
        }

        // 先长链表上走几步，再同时在两个链表上遍历
        for(int i = 0; i < nLengthDif; ++i) {
            pListHeadLong = pListHeadLong.m_pNext;
        }

        while((pListHeadLong != null) && (pListHeadShort != null) && (pListHeadLong != pListHeadShort)){
            pListHeadLong = pListHeadLong.m_pNext;
            pListHeadShort = pListHeadShort.m_pNext;
        }

        // 得到第一个公共节点
        ListNode pFirstCommonNode = pListHeadLong;
        return pFirstCommonNode;
    }

    private static int GetListLength(ListNode pHead) {
        int nLength = 0;
        ListNode pNode = pHead;
        while(pNode != null) {
            ++nLength;
            pNode = pNode.m_pNext;
        }


        return nLength;
    }
}
