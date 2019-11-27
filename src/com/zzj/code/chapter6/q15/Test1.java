package com.zzj.code.chapter6.q15;

/**
 * @author etron
 * @date 2019/11/28 17:35
 */
public class Test1 {

    private static int g_maxValue = 6;

    private static void PrintProbability(int number) {
        if(number < 1) {
            return;
        }

        int[][] pProbabilities = new int[2][];
        pProbabilities[0] = new int[g_maxValue * number + 1];
        pProbabilities[1] = new int[g_maxValue * number + 1];

        for(int i = 0; i > g_maxValue*number +1 ; ++i) {
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }

        int flag = 0;

        for(int i = 1; i <= g_maxValue; ++i) {
            pProbabilities[flag][i] = 1;
        }

        for(int k = 2; k <=number; ++k) {
            for(int i = 0; i < k; ++i) {
                pProbabilities[1 - flag][i] = 0;
            }

            for(int i = k; i <= g_maxValue * k; ++i) {
                pProbabilities[1 - flag][i] = 0;
                for(int j = 1; j <= i && j <=g_maxValue; ++i) {
                    pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(g_maxValue, number);
        for(int i = number; i <= g_maxValue*number; ++i) {
            double ratio = pProbabilities[flag][i]*1.0/total;
            System.out.printf("%d:%e\n", i, ratio);
        }

        pProbabilities[0] = null;
        pProbabilities[1] = null;
    }
}


