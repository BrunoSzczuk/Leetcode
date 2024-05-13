package br.com.brunoszczuk.leetcode.medium._2023_06_10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.TreeSet
import kotlin.collections.HashMap


class DesignANumberContainerSystem {
    class NumberContainers {
        val changeHashMap = HashMap<Int, Int>()
        val findHashMap = HashMap<Int, TreeSet<Int>>()

        fun change(index: Int, number: Int) {
            changeHashMap[index]?.let { oldNumber ->
                findHashMap[oldNumber]?.remove(index)
            }

            changeHashMap[index] = number
            findHashMap.computeIfAbsent(number) { TreeSet() }.add(index)
        }

        fun find(number: Int): Int {
            return findHashMap[number]?.firstOrNull() ?: -1
        }


        @Test
        fun testFind1() {
            val nc = NumberContainers()
            assertEquals(-1, nc.find(10))
            nc.change(75, 40)
            assertEquals(-1, nc.find(14))
            assertEquals(-1, nc.find(41))
            assertEquals(75, nc.find(40))
            nc.change(27, 40)
            nc.change(22, 14)
            nc.change(85, 14)
            nc.change(22, 40)
            nc.change(18, 34)
            nc.change(92, 41)
            nc.change(22, 40)
            nc.change(75, 40)
            nc.change(59, 34)
            assertEquals(22, nc.find(40))
            nc.change(27, 14)
            assertEquals(18, nc.find(34))
            assertEquals(27, nc.find(14))
            nc.change(13, 34)
            assertEquals(22, nc.find(40))

        }

        @Test
        fun testFind2() {
            val nc = NumberContainers()
            assertEquals(-1, nc.find(10))
            nc.change(2, 10) // Your container at index 2 will be filled with number 10.
            nc.change(1, 10) // Your container at index 1 will be filled with number 10.
            nc.change(3, 10) // Your container at index 3 will be filled with number 10.
            nc.change(5, 10) // Your container at index 5 will be filled with number 10.
            assertEquals(1, nc.find(10))  // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
            nc.change(1, 20) // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
            assertEquals(2, nc.find(10)) // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
        }

        @Test
        fun testFind3() {
            val nc = NumberContainers()
            assertEquals(-1, nc.find(10))
            nc.change(1, 10)
            assertEquals(1, nc.find(10))
            nc.change(1, 20)
            assertEquals(1, nc.find(20))
            assertEquals(-1, nc.find(10))
            assertEquals(1, nc.find(20))
            assertEquals(-1, nc.find(30))

        }

    }

}