package br.com.brunoszczuk.leetcode.easy.a20230608

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        //complement | key
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            map[target - nums[i]] = i
        }
        for (i in nums.indices) {
            println("i ${nums[i]} target: ${target - nums[i]}")
            if (map.containsKey(nums[i]) && map[nums[i]] != i)
                return intArrayOf(i, map[nums[i]]!!)
        }
        return intArrayOf()
    }


    @Test
    fun twoSumTestCase1() {
        val returnValue = twoSum(intArrayOf(2, 7, 11, 15), 9)
        println("returnValue = ${returnValue.contentToString()}")
        assert(returnValue.contentEquals(intArrayOf(0, 1)))
    }

    @Test
    fun twuSumTestCase2() {
        val returnValue = twoSum(intArrayOf(3, 2, 4), 6)
        println("returnValue = ${returnValue.contentToString()}")
        assert(returnValue.contentEquals(intArrayOf(1, 2)))
    }
}