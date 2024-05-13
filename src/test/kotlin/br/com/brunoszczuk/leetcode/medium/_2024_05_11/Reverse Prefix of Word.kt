package br.com.brunoszczuk.leetcode.medium._2024_05_11

import org.junit.jupiter.api.Test

class `Reverse Prefix of Word` {
    fun reversePrefix(word: String, ch: Char): String {
        val index = word.indexOf(ch)
        if (index == -1)
            return word
        return word.substring(0, index+1).reversed() + word.substring(index+1, word.length)
    }

    @Test
    fun test() {
        assert(reversePrefix("abcdefd", 'd') == "dcbaefd")
        assert(reversePrefix("xyxzxe", 'z') == "zxyxxe")
        assert(reversePrefix("abcd", 'z') == "abcd")
    }
}