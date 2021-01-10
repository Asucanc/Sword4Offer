package com.algorithm.template;

/**
 * DFS（深度优先搜索）
 * <p>
 * 深度优先搜索的步骤分为 1.递归下去 2.回溯上来。
 * 顾名思义，深度优先，则是以深度为准则，先一条路走到底，直到达到目标。这里称之为递归下去。
 * 否则既没有达到目标又无路可走了，那么则退回到上一步的状态，走其他路。这便是回溯上来。
 *
 * void dfs(int step)
 * {
 *         判断边界
 *         {
 *             相应操作
 *         }
 *         尝试每一种可能
 *         {
 *                满足check条件
 *                标记
 *                继续下一步dfs(step+1)
 *                恢复初始状态（回溯的时候要用到）
 *         }
 * }
 */
public class DFS {
    /**
     * 关于图的深度优先搜索算法。
     *
     * @param graph
     * @param visited
     * @param x
     * @param y
     */
    public boolean dfs(int[][] graph, int[][] visited, int target, int x, int y) {
        int width = visited.length;
        int height = visited[0].length;
        if (x >= 0 && x < width && y >= 0 && y < height && graph[x][y] == target) {
            System.out.println("target found: (" + x + ", " + y + ")");
            return true;
        }
        if (x >= 0 && x < width && y >= 0 && y < height && visited[x][y] != 1) {
            visited[x][y] = 1;
            return dfs(graph, visited, target, x - 1, y)
                    || dfs(graph, visited, target, x, y - 1)
                    || dfs(graph, visited, target, x + 1, y)
                    || dfs(graph, visited, target, x, y + 1);
        }
        return false;
    }

    int px[] = {-1, 0, 1, 0};   //通过px 和 py数组来实现左下右上的移动顺序
    int py[] = {0, -1, 0, 1};
    boolean flag = false;

    public void dfs1(int[][] graph, int[][] visited, int target, int x, int y) {
        int width = visited.length;
        int height = visited[0].length;
        if (x >= 0 && x < width && y >= 0 && y < height && graph[x][y] == target) {
            System.out.println("target found: (" + x + ", " + y + ")");
            flag = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int new_x = x + px[i];
            int new_y = y + py[i];
            if (new_x >= 0 && new_x < width && new_y >= 0 && new_y < height && visited[new_x][new_y] != 1 && !flag) {
                visited[new_x][new_y] = 1;
                dfs1(graph, visited, target, new_x, new_y);
                if (!flag) {
                    visited[new_x][new_y] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] graph = new int[10][10];
        int[][] visited = new int[10][10];
        int target = 100;
        graph[8][8] = 100;
        visited[2][2] = 1;
        new DFS().dfs1(graph, visited, target, 2, 2);
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
