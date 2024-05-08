package br.com.brunoszczuk.leetcode.medium.a20240503

import org.junit.jupiter.api.Test
import java.util.*

class OpenTheLock {

    //https://leetcode.com/problems/open-the-lock/
    fun openLock(deadends: Array<String>, target: String): Int {
        val deads = deadends.toSet()
        val visited = mutableSetOf<String>()
        val queue: Queue<Pair<String, Int>> = LinkedList()
        queue.add(Pair("0000", 0))

        while (queue.isNotEmpty()) {
            val (state, turns) = queue.poll()
            if (state in deads || state in visited) continue
            if (state == target) return turns

            visited.add(state)

            for (i in 0..3) {
                val digit = state[i] - '0'
                val nextState1 = state.substring(0, i) + ((digit + 1) % 10) + state.substring(i + 1)
                val nextState2 = state.substring(0, i) + ((digit + 9) % 10) + state.substring(i + 1)
                queue.add(Pair(nextState1, turns + 1))
                queue.add(Pair(nextState2, turns + 1))
            }
        }

        return -1

    }


    @Test
    fun openLockTest() {
        assert(openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202") == 6)
        assert(openLock(arrayOf("8888"), "0009") == 1)
        assert(openLock(arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"), "8888") == -1)
    }
}