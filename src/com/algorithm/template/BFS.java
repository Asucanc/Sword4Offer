package com.algorithm.template;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先搜索算法：
 * 广度优先搜索较之深度优先搜索之不同在于，深度优先搜索旨在不管有多少条岔路，
 * 先一条路走到底，不成功就返回上一个路口然后就选择下一条岔路，
 * 而广度优先搜索旨在面临一个路口时，把所有的岔路口都记下来，然后选择其中一个进入，
 * 然后将它的分路情况记录下来，然后再返回来进入另外一个岔路，并重复这样的操作。
 * 在DFS中我们说关键点是递归以及回溯，在BFS中，关键点则是状态的选取和标记。
 * 因此在BFS的经典实现方法上，可以选择使用队列存储岔路的情况。
 * <p>
 * void BFS()
 * {
 * queue que;              //用队列来保存路口
 * int graph[n][m];          //地图
 * int px[] = {-1, 0, 1, 0};   //移动方向的数组
 * int py[] = {0, -1, 0, 1};
 * que.push(起点入队);      //将起点入队
 * while (!que.empty()) {    //只要队列不为空
 * auto temp = que.pop();          //得到队列中的元素
 * for (int i = 0; i != 4; ++i) {
 * if(//可以走) {
 * //标记当前格子
 * //将当前状态入队列，等待下次提取
 * }
 * }
 * }
 * }
 */
public class BFS {
    Queue<Position> queue = new ArrayDeque<>();
    int[] px = {-1, 0, 1, 0};
    int[] py = {0, -1, 0, 1};

    public void bfs(int[][] graph, int[][] visited, int target, int x, int y) {
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int positionX = current.getX() + px[i];
                int positionY = current.getY() + py[i];
                if (positionX >= 0 && positionX < graph.length
                        && positionY >= 0 && positionY < graph[0].length
                        && visited[positionX][positionY] == 0) {
                    visited[positionX][positionY] = 1;
                    if (graph[positionX][positionY] == target) {
                        System.out.println("target found: (" + positionX + ", " + positionY + ")");
                        return;
                    }
                    queue.add(new Position(positionX, positionY));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[10][10];
        int[][] visited = new int[10][10];
        int target = 100;
        graph[6][8] = 100;
        visited[2][2] = 1;
        new BFS().bfs(graph, visited, target, 2, 2);
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }


    public class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
