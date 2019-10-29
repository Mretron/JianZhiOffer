package com.zzj.code.chapter3.q7;

public class Test {

    /**
     * 找到环中相遇的任何一个节点即可
     * @param pHead
     * @return
     */
    private static ListNode MeetingNode(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        ListNode pSlow = pHead.m_pNext;
        if(pSlow == null) {
            return null;
        }

        // 让pFast起点比pSlow早一个节点
        ListNode pFast = pSlow.m_pNext;
        while(pFast != null && pSlow != null) {
            // 当两者相遇。则找到了
            if(pFast == pSlow) {
                return pFast;
            }

            pSlow = pSlow.m_pNext;
            pFast = pFast.m_pNext;
            if(pFast != null) {
                pFast = pFast.m_pNext;
            }
        }
        return null;
    }

    private static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = MeetingNode(pHead);
        if(meetingNode == null) {
            return null;
        }

        // 得到环中节点的数目
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while(pNode1.m_pNext != meetingNode) {
            pNode1 = pNode1.m_pNext;
            ++nodesInLoop;
        }

        // 先移动pNode1,次数为环中节点的数目
        pNode1 = pHead;
        for(int i=0;i<nodesInLoop; ++i) {
            pNode1 = pNode1.m_pNext;
        }

        // 再移动pNode1和pNode2
        ListNode pNode2 = pHead;
        while(pNode1 != pNode2) {
            pNode1 = pNode1.m_pNext;
            pNode2 = pNode2.m_pNext;
        }
        return pNode1;
    }
}
