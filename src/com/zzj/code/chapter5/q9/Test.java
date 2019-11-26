package com.zzj.code.chapter5.q9;

/**
 * @author etron
 * @date 2019/11/26 13:17
 */
public class Test {


    public static void main(String[] args)
    {
        int[][] values = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        //29
        System.out.println(getMaxPathValue(values));

        int[][] values1 = {{1, 10, 3, 8}};
        //22
        System.out.println(getMaxPathValue(values1));
        int[][] values2 = {
                {1},
                {1},
                {5},
                {3}};
        //10
        System.out.println(getMaxPathValue(values2));
    }

    private static int getMaxPathValue(int[][] values)
    {
        if (values == null) {
            return 0;
        }

        int rows = values.length;
        if (rows <= 0) {
            return 0;
        }
        int cols = values[0].length;
        if (cols <= 0) {
            return 0;
        }

        int[][] maxValues = new int[rows][cols];
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                //左边
                int fromLeft = 0;
                //上面
                int fromUp = 0;

                if (i > 0) {
                    fromUp = maxValues[i - 1][j];
                }
                if (j > 0) {
                    fromLeft = maxValues[i][j - 1];
                }

                maxValues[i][j] = Math.max(fromLeft, fromUp) + values[i][j];
            }
        }
        return maxValues[rows - 1][cols - 1];
    }

}
