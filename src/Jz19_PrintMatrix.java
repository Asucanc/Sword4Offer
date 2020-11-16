import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 * <p>
 * 则依次打印出数字:
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Jz19_PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>(rowSize * columnSize);

        if (rowSize == 1) {
            for (int i = 0; i < columnSize; i++) {
                res.add(matrix[0][i]);
            }
            return res;
        }

        if (columnSize == 1) {
            for (int i = 0; i < rowSize; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }

        int index = 0;
        while (rowSize > 0 && columnSize > 0) {
            printOutLayer(matrix, rowSize, columnSize, index, res);
            rowSize = rowSize - 2;
            columnSize = columnSize - 2;
            index++;
        }

        return res;
    }

    public void printOutLayer(int[][] arr, int row, int column, int index, List list) {
        if (row == 1) {
            for (int i = 0; i < column; i++) {
                list.add(arr[index][i + index]);
            }
            return;
        }
        for (int i = 0; i < column - 1; i++) {
            list.add(arr[index][index + i]);
        }
        for (int i = 0; i < row - 1; i++) {
            list.add(arr[i + index][column - 1 + index]);
        }
        for (int i = 0; i < column - 1; i++) {
            list.add(arr[row - 1 + index][column + index - 1 - i]);
        }
        for (int i = 0; i < row - 1; i++) {
            list.add(arr[row + index - 1 - i][index]);
        }
    }


    public static void main(String[] args) {
        int[][] testData = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
//        int[][] testData = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
//        int[][] testData = {{1}};
//        int[][] testData = {{1},{2},{3},{4},{5}};
        Jz19_PrintMatrix jz19_printMatrix = new Jz19_PrintMatrix();
        System.out.println(jz19_printMatrix.printMatrix(testData));
    }
}
