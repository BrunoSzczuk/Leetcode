package br.com.brunoszczuk.leetcode.medium._2024_05_11

import org.junit.jupiter.api.Test

class `Compare Version Numbers` {
    fun compareVersion(version1: String, version2: String): Int {
        val array1 = version1.split(".")
        val array2 = version2.split(".")
        val size = maxOf(array1.size, array2.size)
        for (i in 0 until size) {
            val valor1 = array1.getOrElse(i) { "0" }.toInt()
            val valor2 = array2.getOrElse(i) { "0" }.toInt()
            if (valor1 > valor2) {
                return 1
            } else if (valor2 > valor1) {
                return -1
            }
        }
        return 0
    }

    @Test
    fun test() {
        assert(compareVersion("1", "1.0.1") == -1)
        assert(compareVersion("1.10", "1.2") == 1)
        assert(compareVersion("1.01", "1.001") == 0)
        assert(compareVersion("1.2", "1.10") == -1)
        assert(compareVersion("1.0", "1.0.0.0") == 0)

    }
}