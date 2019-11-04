package com.zzj.code.chapter4.q3;

/**
 * @author etron
 * @date 2019/11/3 22:16
 */
public class Test {

    private static void PrintMatrixClockwisely(int[][] numbers, int columns, int rows) {
        if(numbers == null || columns <=0 || rows <= 0) {
            return;
        }

        // 这个start有两个作用
        // 1.start作为一圈的起点坐标，进行开始打印矩阵
        // 2.一圈意味着行和列都减少两个，让start作为判断循环结束的变量
        int start = 0;

        while(columns > start * 2 && rows > start * 2) {
            PrintMatrixInCircle(numbers, columns, rows, start);
            // 每加一次，说明打印了一圈
            ++start;
        }
    }

    private static void PrintMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for(int i = start; i <= endX; i++) {
            int number = numbers[start][i];
            System.out.print(number);
        }

        // 从上到下打印一列
        if(start < endY) {
            for(int i = start + 1; i < endY; ++i) {
                int number = numbers[i][endX];
                System.out.println(number);
            }
        }

        //从右到左打印一行
        if(start < endX && start < endY) {
            for(int i = endX - 1; i>=start; --i){
                int number = numbers[endY][i];
                System.out.print(number);
            }
        }

        //从下到上打印一列
        if(start < endY && start < endY - 1) {
            for(int i = endY - 1; i >=start + 1; --i) {
                int number = numbers[i][start];
                System.out.print(number);
            }
        }
    }

}
