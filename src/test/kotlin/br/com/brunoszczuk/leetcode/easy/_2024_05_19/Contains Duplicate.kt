package br.com.brunoszczuk.leetcode.easy._2024_05_19

import org.junit.jupiter.api.Test

class `Contains Duplicate` {
    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.distinct().size != nums.size
    }

    @Test
    fun test() {
        assert(containsDuplicate(intArrayOf(1, 2, 3, 1)))
        assert(!containsDuplicate(intArrayOf(1, 2, 3, 4)))
        assert(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    }
}