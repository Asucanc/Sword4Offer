package com.algorithm.sword4offer;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * <p>
 * 思路：回溯法
 * 从（0，0）出发，如果当前坐标符合条件，结果加一，将当前点标记为已经访问过的点，然后从4个方向分别探索。
 * 其中会用到递归，递归的出口为：当前点不符合条件：即为超出边界，已经访问过，此点的数位之和超出限制。
 */
public class Jz66_MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] visit = new int[rows][cols];
        return movingCount(0, 0, threshold, visit, rows, cols);
    }

    private int movingCount(int x, int y, int threshold, int[][] visit, int rows, int cols) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || getDigitsSum(x, y) > threshold || visit[x][y] == 1) {
            return 0;
        } else {
            visit[x][y] = 1;
            return movingCount(x - 1, y, threshold, visit, rows, cols) +
                    movingCount(x + 1, y, threshold, visit, rows, cols) +
                    movingCount(x, y - 1, threshold, visit, rows, cols) +
                    movingCount(x, y + 1, threshold, visit, rows, cols) +
                    1;
        }
    }

    private int getDigitsSum(int x, int y) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        Jz66_MovingCount movingCount = new Jz66_MovingCount();
        System.out.println(movingCount.movingCount(10,1, 100));
    }
}
