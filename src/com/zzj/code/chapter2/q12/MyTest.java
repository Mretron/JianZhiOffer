package com.zzj.code.chapter2.q12;

public class MyTest {


    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if(matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }

        // 标记数组，用来判断这个节点是否被访问
        boolean[] visited = new boolean[rows * cols];

        int pathLength = 0;

        for(int row = 0 ; row < rows ; ++row) {
            for(int col = 0 ; col < cols ; ++ col) {
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        visited = null;

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row,
                                        int col, char[] str, int pathLength, boolean[] visited) {
        // 计算出一位数组中表示的下标
        int index = row * cols + col;

        // 行列索引超限
        // 当前字符已经被访问过
        // 当前字符不等于目标字符序列的当前字符
        // 直接返回false
        if(row < 0 || col < 0 || row >= rows || col >= cols ||
            visited[index] || matrix[index] != str[pathLength]) {
            return false;
        }

        // 否则就符合条件
        visited[index] = true;

        // 说明找完了
        if(pathLength == str.length - 1) {
            return  true;
        }

        // 没找完，匹配当前的字母
        pathLength++;

        // 在当前字符的上、下、左、右
        if(hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)) {
            return true;
        }

        // 在当前字符的上、 下、左、右的元素没有搜索到下一个目标字符，将访问标记重置为false，返回false
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
