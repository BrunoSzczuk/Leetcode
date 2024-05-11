package br.com.brunoszczuk.leetcode.medium.a20240511

import org.junit.jupiter.api.Test
import kotlin.math.pow

class `Maximize Happiness of Selected Children` {

    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        var sum = 0L
        var totalPerdido = 0

        happiness.sortedDescending().take(k).forEach{ i ->
             if (i - totalPerdido <= 0) return@forEach
             sum += i - totalPerdido
             totalPerdido++
         }
        return sum
    }

    @Test
    fun test(){
        assert(maximumHappinessSum(intArrayOf(12,1,42), 3) == 53L)
        assert(maximumHappinessSum(intArrayOf(2,83,62), 3) == 144L)
        assert(maximumHappinessSum(intArrayOf(1,2,3), 2) == 4L)
        assert(maximumHappinessSum(intArrayOf(1,1,1), 2) == 1L)
        assert(maximumHappinessSum(intArrayOf(2,3,4,5), 1) == 5L)

    }

}