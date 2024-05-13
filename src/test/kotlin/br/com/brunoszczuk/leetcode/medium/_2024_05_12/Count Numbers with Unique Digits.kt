package br.com.brunoszczuk.leetcode.medium._2024_05_12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.roundToInt

class `Count Numbers with Unique Digits` {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        if(n ==0 ) return 1
        var digitosUnicos = 9
        var resultado = 10
        for (i in 2..n) {
            digitosUnicos *= 10 - i + 1
            resultado += digitosUnicos
        }
        return resultado
    }

    @Test
    fun test() {
        assert(countNumbersWithUniqueDigits(2) == 91)
        assert(countNumbersWithUniqueDigits(0) == 1)
        assert(countNumbersWithUniqueDigits(1) == 10)
        assert(countNumbersWithUniqueDigits(3) == 739)
    }
}