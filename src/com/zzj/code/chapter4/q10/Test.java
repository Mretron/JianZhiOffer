package com.zzj.code.chapter4.q10;

/**
 * @author etron
 * @date 2019/11/4 22:20
 */
public class Test {
    private static void CloneNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while(pNode != null) {
            ComplexListNode pCloud = new ComplexListNode();
            pCloud.m_nValue = pNode.m_nValue;
            pCloud.m_pNext = pNode.m_pNext;
            pCloud.m_pSibing = null;

            pNode.m_pNext = pCloud;

            pNode = pCloud.m_pNext;
        }
    }

    private static void ConnectSibingNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while(pNode != null) {
            ComplexListNode pCloud = pNode.m_pNext;
            if(pNode.m_pSibing != null) {
                pCloud.m_pSibing = pNode.m_pSibing.m_pNext;
            }

            pNode = pCloud.m_pNext;
        }
    }

    private static ComplexListNode ReconnectNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        ComplexListNode pClonedHead = null;
        ComplexListNode pClonedNode = null;

        if(pNode != null) {
            pClonedHead = pClonedNode = pNode.m_pNext;
            pNode.m_pNext = pClonedNode.m_pNext;
            pNode = pNode.m_pNext;
        }

        while(pNode != null) {
            pClonedNode.m_pNext = pNode.m_pNext;
            pClonedNode = pClonedNode.m_pNext;
            pNode.m_pNext = pClonedNode.m_pNext;
            pNode = pNode.m_pNext;
        }

        return pClonedHead;
    }

    private static ComplexListNode Clone(ComplexListNode pHead) {
        CloneNodes(pHead);
        ConnectSibingNodes(pHead);
        return ReconnectNodes(pHead);
    }
}
