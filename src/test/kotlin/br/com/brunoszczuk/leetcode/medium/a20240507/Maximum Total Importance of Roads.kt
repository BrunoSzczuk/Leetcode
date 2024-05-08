package br.com.brunoszczuk.leetcode.medium.a20240507

import org.junit.jupiter.api.Test

class `Maximum Total Importance of Roads` {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val cities = LongArray(n)
        for (road: IntArray in roads) {
            for (city: Int in road) {
                cities[city]++
            }
        }

        cities.sortDescending()
        var i = n
        var sum = 0L
        for (city: Long in cities) {
            sum += city * i
            i--
        }
        return sum

    }
    @Test
    fun `should test correctly`(){
        assert(maximumImportance(5, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,3), intArrayOf(0,2), intArrayOf(1,3), intArrayOf(2,4))) == 43L)
        assert(maximumImportance(5, arrayOf(intArrayOf(0,3), intArrayOf(2,4), intArrayOf(1,3))) == 20L)
    }
}
