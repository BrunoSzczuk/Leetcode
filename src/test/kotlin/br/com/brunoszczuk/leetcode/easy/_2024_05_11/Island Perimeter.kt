package br.com.brunoszczuk.leetcode.easy._2024_05_11

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Island Perimeter` {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var sum = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    sum += 4 - top(grid, i, j) - left(grid, i, j) - right(grid, i, j) - down(grid, i, j)
                }
            }
        }
        return sum

    }

    private fun left(grid: Array<IntArray>, i: Int, j: Int): Int {
        return if (j > 0 && grid[i][j - 1] == 1) 1 else 0
    }

    private fun right(grid: Array<IntArray>, i: Int, j: Int): Int {
        return if (j < grid[i].size-1 && grid[i][j + 1] == 1) 1 else 0
    }

    private fun top(grid: Array<IntArray>, i: Int, j: Int): Int {
        return if (i > 0 && grid[i - 1][j] == 1) 1 else 0
    }

    private fun down(grid: Array<IntArray>, i: Int, j: Int): Int {
        return if (i < grid.size-1 && grid[i + 1][j] == 1) 1 else 0
    }

    @Test
    fun test() {
        Assertions.assertEquals(
            16,
            islandPerimeter(
                arrayOf(
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(1, 1, 0, 0)
                )
            )
        )
        Assertions.assertEquals(4, islandPerimeter(arrayOf(intArrayOf(1))))
        Assertions.assertEquals(4, islandPerimeter(arrayOf(intArrayOf(1, 0))))


    }
}