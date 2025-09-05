package org.example.algorithm.dynamic_programming;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class MiniumFallPath {

    public int miniumFallPath(int[][] cost) {
        int rows = cost.length;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                cost[i][j] = Math.min(cost[i - 1][j],
                        Math.min(cost[i - 1][Math.max(0, j - 1)], cost[i - 1][Math.min(j + 1, cost[i].length - 1)]))
                        + cost[i][j];
            }
        }
        return Arrays.stream(cost[rows - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        MiniumFallPath miniumFallPath = new MiniumFallPath();
        int res = miniumFallPath.miniumFallPath(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
        Assert.assertEquals(13, res);
        res = miniumFallPath.miniumFallPathLocal(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
        Assert.assertEquals(13, res);
        int res2 = miniumFallPath.miniumFallPath(new int[][]{{-19, 57}, {-40, 5}});
        Assert.assertEquals(-59, res2);
        res2 = miniumFallPath.miniumFallPathLocal(new int[][]{{-19, 57}, {-40, 5}});
        Assert.assertEquals(-59, res2);
    }

    public int miniumFallPathLocal(int[][] cost) {
        for (int i = 1; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                cost[i][j] = Math.min(cost[i - 1][j], Math.min(cost[i - 1][Math.max(0, i - 1)], cost[i - 1][Math.min(j + 1, cost[i].length - 1)])) + cost[i][j];
            }
        }
        return Arrays.stream(cost[cost.length - 1]).min().getAsInt();
    }
}
