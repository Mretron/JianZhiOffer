package com.zzj.code.chapter4.q12;

/**
 * @author etron
 * @date 2019/11/10 18:57
 */
public class Test {

    public int index = -1;
    private static String Serialize(BinaryTreeNode pRoot) {
        StringBuilder s = new StringBuilder();
        if(pRoot == null) {
            s.append("#,");
            return s.toString();
        }
        s.append(pRoot.m_nValue+",");
        s.append(Serialize(pRoot.m_pLeft));
        s.append(Serialize(pRoot.m_pRight));
        return s.toString();
    }

    BinaryTreeNode Deserialize(String str) {
        index++;
        String[] DLRseq = str.split(",");
        BinaryTreeNode leave = null;
        if(!DLRseq[index].equals("#")){
            leave = new BinaryTreeNode();
            leave.m_nValue = Integer.valueOf(DLRseq[index]);
            leave.m_pLeft = Deserialize(str);
            leave.m_pRight = Deserialize(str);
        }
        return leave;
    }

}
