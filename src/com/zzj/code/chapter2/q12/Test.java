package com.zzj.code.chapter2.q12;

public class Test {

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }

        boolean[] visited = new boolean[rows*cols];

        int pathLength = 0;
        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(hasPathCore(matrix, rows, cols, row, col, str,
                        pathLength, visited))
                {
                    return true;
                }
            }
        }
        visited = null;

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row,
                                       int col, char[] str, int pathLength, boolean[] visited) {
        int index = row * cols + col;

        // 行列索引超限、当前字符已经被访问过、当前字符不等于目标字符序列的当前字符，直接返回false
        if(row < 0 || col < 0 || row >= rows || col >= cols ||
            visited[index] || matrix[index] != str[pathLength]) {
            return false;
        }

        // 设置访问标记
        visited[index] = true;

        // 递归结束条件，k已经到达目标字符序列的最后一个字符
        if(pathLength == str.length - 1) {
            return true;
        }

        // 匹配目标字符序列的下一个字符
        pathLength++;

        // 在当前字符的上、下、左、右
        if(hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)) {
            return true;
        }

        // 在当前字符的上、下、左、右的元素没有搜索到下一个目标字符，将访问标记重置为false,返回false
        visited[index] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','t', 'g',
                         'c','f','c', 's',
                         'j','d','e', 'h'
        };

        char[] str = {'b','f','c','e'};
        System.out.println(hasPath(matrix,3,4,str));
    }

}
