package com.zzj.code.chapter2.q3;

public class MyTest {
    private static int[][] matrix = new int[][]{
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
    };

    public static void main(String[] args) {
        System.out.println(Find(matrix, 4, 4, 7));
    }

    private static boolean Find(int[][] matrix, int rows, int columns, int number) {

        boolean found = false;
        if(matrix != null && rows > 0 && columns > 0 ) {
            int row = 0;
            int column = columns - 1;
            while(row <= rows && column >= 0) {
                if(matrix[row][column] == number) {
                    return true;
                } else if(matrix[row][column] > number) {
                    --column;
                } else {
                    ++row;
                }
            }
        }
        return found;
    }
}
