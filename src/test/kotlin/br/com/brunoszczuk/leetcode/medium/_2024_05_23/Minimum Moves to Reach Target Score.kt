package br.com.brunoszczuk.leetcode.medium._2024_05_23

import org.junit.jupiter.api.Test

class `Minimum Moves to Reach Target Score` {
    fun minMoves(target: Int, maxDoubles: Int): Int {
        if (maxDoubles == 0){
            return target-1
        }
        var targetRemaining = target
        var doublesRemaining = maxDoubles
        var moves = 0
        while (targetRemaining >1){
            if (doublesRemaining > 0  && (targetRemaining % 2 == 0)){
                targetRemaining /= 2
                doublesRemaining--
            }else{
                targetRemaining--
            }
            moves++
        }
        return moves
    }
    @Test
    fun test() {
        assert(minMoves(5, 0) == 4)
        assert(minMoves(10, 4) == 4)
    }

    data class Movement(var value: Int = 0) {
        fun increment() {
            value = value++
        }

        fun double() {
            value *= 2
        }
    }
}