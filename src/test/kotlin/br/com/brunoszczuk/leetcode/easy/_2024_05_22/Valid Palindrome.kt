package br.com.brunoszczuk.leetcode.easy._2024_05_22

import org.junit.jupiter.api.Test

class `Valid Palindrome` {
    fun isPalindrome(s: String): Boolean {
        val distinctWord = mutableListOf<Char>()
        for (i in s.indices){
            if (s[i].isLetterOrDigit()){
                distinctWord.add(s[i].lowercaseChar())
            }

        }
        val half = distinctWord.size / 2
        for (i in 0 until half){
            if (distinctWord[i] != distinctWord[distinctWord.size - 1 - i]){
                return false
            }
        }

        return true
    }


    @Test
    fun test(){
        assert(isPalindrome("A man, a plan, a canal: Panama"))
    }
}