package br.com.brunoszczuk.leetcode.hard._2024_05_19

import org.junit.jupiter.api.Test

class `Count of Range Sum` {

    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        var count = 0
        val sum = LongArray(nums.size + 1)
        for (i in nums.indices) {
            sum[i + 1] = sum[i] + nums[i]
        }
        for (i in nums.indices) {
            for (j in i + 1 until sum.size) {
                if (sum[j] - sum[i] in lower..upper) {
                    count++
                }
            }
        }
        return count
    }

    @Test
    fun test(){
        assert(countRangeSum(intArrayOf(-2,5,-1), -2, 2) == 3)
        assert(countRangeSum(intArrayOf(0), 0, 0) == 1)
        assert(countRangeSum(intArrayOf(0,0), 0, 0) == 3)
    }
}