package br.com.brunoszczuk.leetcode.easy._2024_05_11

import org.junit.jupiter.api.Test

class `N-th Tribonacci Number`{
    fun tribonacci(n: Int): Int {
        if (n == 0 || n ==1)
            return n
        var t1 = 0
        var t2 = 1
        var t3 = 1
        repeat(n -2){
            val temp = t1+t2+t3
            t1 = t2
            t2 = t3
            t3 = temp
        }
        return t3
    }

    @Test
    fun test(){
        assert(tribonacci(4) == 4)
        assert(tribonacci(25) == 1389537)
    }

}