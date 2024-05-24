package br.com.brunoszczuk.leetcode.easy._2024_05_23

import org.junit.jupiter.api.Test

class `Sort Array By Parity` {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var even = 0
        var odd = nums.size - 1
        while (even < odd) {
            if (nums[even] % 2 > nums[odd] % 2) {
                val temp = nums[even]
                nums[even] = nums[odd]
                nums[odd] = temp
            }
            if (nums[even] % 2 == 0) even++
            if (nums[odd] % 2 == 1) odd--
        }
        return nums
    }

    @Test
    fun test() {
        assert(sortArrayByParity(intArrayOf(3,1,2,4)).contentEquals(intArrayOf(2,4,3,1)))

    }
}