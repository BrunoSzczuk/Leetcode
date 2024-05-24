package br.com.brunoszczuk.leetcode.medium._2024_05_19

import org.junit.jupiter.api.Test

class `H-Index` {
    fun hIndex(citations: IntArray): Int {
        var higherValue = citations.size
        citations.sort()
        for (i in citations){
            if (i >= higherValue){
                return higherValue
            }
            higherValue --

        }
        return higherValue
    }


    @Test
    fun test(){
        assert(hIndex(intArrayOf(3,0,6,1,5)) == 3)
        assert(hIndex(intArrayOf(1,3,1)) == 1)
        assert(hIndex(intArrayOf(0,0,0,0,0)) == 0)
        assert(hIndex(intArrayOf(0,1,3,5,6)) == 3)
    }
}