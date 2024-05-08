package br.com.brunoszczuk.leetcode.hard.a20240508

import org.junit.jupiter.api.Test

class `Minimum Money Required Before Transactions` {
    fun minimumMoney(transactions: Array<IntArray>): Long {
        // preciso ordenar por menor cashback, onde os primeiros registros precisam ter custo maior que cashback
        val transactionList =
            transactions.map { Transaction(it[0].toLong(), it[1].toLong()) }.filter { it.cost > it.cashBack }.sortedBy { it.cashBack }.toMutableList()
        val aditional : Transaction? =
            transactions.map { Transaction(it[0].toLong(), it[1].toLong()) }.filter { !transactionList.contains(it) }
                .maxByOrNull { it.cost }
        if (aditional != null) {
            transactionList.add(aditional)
        }
        var moneyNecessary = 0L
        var previousCashback = 0L
        transactionList.forEach {
            run {
                if ((moneyNecessary + it.cost - previousCashback) > moneyNecessary) {
                    moneyNecessary += it.cost - previousCashback
                }

                previousCashback = it.cashBack
            }
        }
        println(moneyNecessary)
        return moneyNecessary

    }

    data class Transaction(val cost: Long, val cashBack: Long)

    @Test
    fun test() {
        assert(
            minimumMoney(
                arrayOf(
                    intArrayOf(3, 9),
                    intArrayOf(0, 4),
                    intArrayOf(7, 10),
                    intArrayOf(3, 5),
                    intArrayOf(0, 9),
                    intArrayOf(9, 3),
                    intArrayOf(7, 4),
                    intArrayOf(3, 3),
                    intArrayOf(8, 0)
                )
            ) == 24L
        )
        assert(
            minimumMoney(
                arrayOf(
                    intArrayOf(7, 2),
                    intArrayOf(0, 10),
                    intArrayOf(5, 0),
                    intArrayOf(4, 1),
                    intArrayOf(5, 8),
                    intArrayOf(5, 9)
                )
            ) == 18L
        )
        assert(minimumMoney(arrayOf(intArrayOf(2, 1), intArrayOf(5, 0), intArrayOf(4, 2))) == 10L)
        assert(minimumMoney(arrayOf(intArrayOf(3, 0), intArrayOf(0, 3))) == 3L)
    }
}