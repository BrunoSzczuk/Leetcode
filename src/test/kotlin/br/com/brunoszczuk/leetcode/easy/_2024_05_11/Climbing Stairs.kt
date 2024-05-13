package br.com.brunoszczuk.leetcode.easy._2024_05_11

import org.junit.jupiter.api.Test

class `Climbing Stairs` {
    fun climbStairs(n: Int): Int {
        val stack = IntArray(maxOf(n+1, 3))
        stack[1] = 1
        stack[2] = 2
        for (i in 3..n) {
            stack[i] = stack[i - 1] + stack[i -2]
        }
        return stack[n]
    }

    @Test
    fun test() {
        assert(climbStairs(5) == 8)
        assert(climbStairs(2) == 2)
        assert(climbStairs(4) == 5)
        assert(climbStairs(3) == 3)
    }
}