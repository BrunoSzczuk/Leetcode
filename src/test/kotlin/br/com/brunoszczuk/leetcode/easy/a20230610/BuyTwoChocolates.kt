package br.com.brunoszczuk.leetcode.easy.a20230610

import org.junit.jupiter.api.Test

class BuyTwoChocolates {
    fun buyChoco(prices: IntArray, money: Int): Int {
        var minPrice1 = Int.MAX_VALUE
        var minPrice2 = Int.MAX_VALUE

        for (price in prices) {
            if (price < minPrice1) {
                minPrice2 = minPrice1
                minPrice1 = price
            } else if (price < minPrice2) {
                minPrice2 = price
            }
        }

        val totalPrice = minPrice1 + minPrice2

        return if (totalPrice > money) {
            money
        } else {
            money - totalPrice
        }
    }

    @Test
    fun buyChocoTest() {
        val returnValue = buyChoco(intArrayOf(1, 2, 2), 3)
        println("returnValue =  $returnValue")
        assert(returnValue == 0)
    }

    @Test
    fun buyChocoTest2() {
        val returnValue = buyChoco(intArrayOf(3, 2, 3), 3)
        println("returnValue =  $returnValue")
        assert(returnValue == 3)
    }

    @Test
    fun buyChocoTest3() {
        val returnValue = buyChoco(intArrayOf(98, 54, 6, 34, 66, 63, 52, 39), 62)
        println("returnValue =  $returnValue")
        assert(returnValue == 22)
    }


}