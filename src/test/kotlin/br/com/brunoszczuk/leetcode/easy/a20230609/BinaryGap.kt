package br.com.brunoszczuk.leetcode.easy.a20230609

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BinaryGap {

    fun binaryGap(n: Int): Int {
        val binaryString = Integer.toBinaryString(n)
        var max = 0
        var count = 0
        for (i in binaryString.indices) {
            if (binaryString[i] == '1') {
                if (count > max) max = count
                count = 1
            } else {
                count++
            }
        }
        return max
    }


    @ParameterizedTest
    @CsvSource(
        "22,2",
        "5,2",
        "6,1",
        "8,0",
        "1,0"
    )
    fun binaryGapTest(param: Int, expected: Int) {
        val returnValue = binaryGap(param)
        println("returnValue =  $returnValue")
        assert(returnValue == expected)
    }
}