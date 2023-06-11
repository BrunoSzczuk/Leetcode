package br.com.brunoszczuk.leetcode.medium.a20230607

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


class SplitLinkedListInParts {
    //https://leetcode.com/problems/split-linked-list-in-parts/
    fun splitListToParts(head: IntArray, splitSize: Int): List<IntArray> {

        val result: ArrayList<IntArray> = ArrayList()
        val splits: Int = head.size.div(splitSize).or(1)
        var differentsSizeDimension = head.size.mod(splitSize)
        var index = 0
        for (i in 0 until splits) {
            var splitSizeVar = splitSize
            if (differentsSizeDimension > 0 && splits > 1) {
                splitSizeVar = splitSize + 1
                differentsSizeDimension--
            }
            val array = IntArray(splitSizeVar)
            for (j in 0 until splitSizeVar) {
                if (head.size <= index) break
                array[j] = head[index]
                index++
            }
            result.add(array)
        }
        return result
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun splitListToPartsTest(param: IntArray, splitSize: Int, expected: List<IntArray>) {
        val returnValue = splitListToParts(param, splitSize)
        for (i in expected.indices) {
            println("expected[i] = ${expected[i].contentToString()} returnValue[i] = ${returnValue[i].contentToString()}")
            assertTrue(expected[i].contentEquals(returnValue[i]))
        }
    }

    companion object {
        @JvmStatic
        fun testCases(): List<Array<Any>> {
            return listOf(
                    arrayOf(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3, listOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7), intArrayOf(8, 9, 10))),
                    arrayOf(intArrayOf(1, 2, 3), 5, listOf(intArrayOf(1, 2, 3, 0, 0)))
            )
        }
    }
}
