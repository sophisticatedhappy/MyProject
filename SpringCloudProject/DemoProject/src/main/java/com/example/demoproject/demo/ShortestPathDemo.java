package com.example.demoproject.demo;

public class ShortestPathDemo {

    /*
    输入一个n*m的二维整数数组，表示一个矩阵，每个元素表示路径长度，请输出矩阵中从上到下的最短路径。（矩阵的第一个一维数组为上边，最后一个一维数组为下边）。
例如，输入2*3的矩阵[[1,2,3],[4,5,6]],那么矩阵排版如下：
[[1,2,3],
[5,4,6]]
上边为[1,2,3]，下边为[5,4,6].
元素1往下走可通过5和4，元素2往下走可通过5，4，6，因此最短路径为1+4 = 5，输出5

这道题用java做
     */
    public static int shortestPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // 创建一个二维数组 dp 来存储从第一行到每一个位置的最短路径
        int[][] dp = new int[n][m];

        // 初始化第一行，第一行的最短路径就是其本身的值
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // 从第二行开始，计算到每一个位置的最短路径
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minPrev = Integer.MAX_VALUE;
                // 考虑从上方元素到达当前元素的最短路径
                minPrev = Math.min(minPrev, dp[i - 1][j]);
                // 如果当前元素不是第一列，考虑从左上方元素到达当前元素的最短路径
                if (j > 0) {
                    minPrev = Math.min(minPrev, dp[i - 1][j - 1]);
                }
                // 如果当前元素不是最后一列，考虑从右上方元素到达当前元素的最短路径
                if (j < m - 1) {
                    minPrev = Math.min(minPrev, dp[i - 1][j + 1]);
                }
                // 当前位置的最短路径等于上方元素的最短路径加上当前元素的值
                dp[i][j] = minPrev + matrix[i][j];
            }
        }

        // 最后一行中的最小值即为从上到下的最短路径
        int minPath = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minPath = Math.min(minPath, dp[n - 1][j]);
        }

        return minPath;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {5, 4, 6}
        };
        int result = shortestPath(matrix);
        System.out.println(result);
    }


}
