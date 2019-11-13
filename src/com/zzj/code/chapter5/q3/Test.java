package com.zzj.code.chapter5.q3;

/**
 * @author etron
 * @date 2019/11/13 11:42
 */
public class Test {
    private static boolean g_InvalidInput = false;

    private static int FindGreatestSumOfSubArray(int[] pData) {
        if(pData == null ) {
            g_InvalidInput = true;
            return 0;
        }

        g_InvalidInput = false;

        int nCurSum = 0;
        int nGreatestSum = 0x80000000;
        for(int i = 0 ; i < pData.length; ++i) {
            if (nCurSum <= 0) {
                nCurSum = pData[i];
            } else {
                nCurSum += pData[i];
            }

            if(nCurSum > nGreatestSum) {
                nGreatestSum = nCurSum;
            }
        }

        return nGreatestSum;
    }
}
