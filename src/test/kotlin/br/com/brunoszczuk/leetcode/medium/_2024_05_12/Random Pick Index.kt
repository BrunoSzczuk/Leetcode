package br.com.brunoszczuk.leetcode.medium._2024_05_12

import org.junit.jupiter.api.Test
import java.util.Random

class `Random Pick Index` (nums: IntArray) {
    val numbers = HashMap<Int, MutableList<Int>>()
    private val random = Random()
    init {
        for (i in nums.indices){
            numbers.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }
    }
    fun pick(target: Int): Int {
        val num = numbers[target]
        return num!![random.nextInt(num.size)]
    }

}

class Test {
    @Test
    fun test(){
        val randompick = `Random Pick Index`(intArrayOf(1,2,3,3,3))
        println(randompick.pick(1))
        println(randompick.pick(3))
        println(randompick.pick(3))
        println(randompick.pick(3))
        println(randompick.pick(3))
        println(randompick.pick(3))
    }
}
