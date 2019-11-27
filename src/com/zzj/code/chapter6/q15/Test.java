package com.zzj.code.chapter6.q15;

/**
 * @author etron
 * @date 2019/11/28 17:19
 */
public class Test {

    private static int g_maxValue = 6;


    /**
     * 基于递归求骰子点数，书剑效率不够高
     * @param number
     */
    private static void PrintProbability(int number) {
        if(number < 1) {
            return;
        }

        // 所有骰子可能产生的最大的和
        int maxSum = number * g_maxValue;
        // 可能产生maxSum - number + 1种和
        int[] pProbabilities = new int[maxSum - number + 1];
        for(int i = number; i <= maxSum; i++) {
            // 将次数全部赋值为0
            pProbabilities[i - number] = 0;
        }

        // 记录每个和产生的次数
        Probability(number, pProbabilities);

        // 得到求概率的分母，总的次数
        int total = (int)Math.pow(g_maxValue, number);
        // 求概率
        for(int i = number; i <= maxSum; i++) {
            double ratio = pProbabilities[i - number]*1.0/total;
            System.out.printf("%d:%e\n", i, ratio);
        }
        pProbabilities = null;

    }

    private static void Probability(int number, int[] pProbabilities) {
        // 模拟第一个骰子的所有情况
        for(int i = 1; i <= g_maxValue; ++i) {
            Probability(number, number, i ,pProbabilities);
        }
    }

    /**
     *
     * @param original
     * @param current 剩余还没投的骰子
     * @param sum 当前的总点数
     * @param pProbabilities
     */
    private static void Probability(int original, int current, int sum,
                                    int[] pProbabilities) {
        if(current == 1) {
            // 说明最后一个骰子也投了
            // 这时的总和已经可以被记录了
            // 因为下标0 代表最小都为1的情况
            pProbabilities[sum - original] ++;
        } else {
            for(int i = 1; i <= g_maxValue; ++i) {
                Probability(original, current - 1, i + sum, pProbabilities);
            }
        }
    }
}
