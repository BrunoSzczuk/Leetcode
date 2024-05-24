package br.com.brunoszczuk.leetcode.medium

import org.junit.jupiter.api.Test

class `Possible Bipartition` {
    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        if (n % 2 != 0) {
            return false
        }
        val distinctPeople = mutableMapOf<Int, HashSet<IntArray>>()
        for (group in dislikes){
            for (person in group){
                if (distinctPeople[person] == null){
                    distinctPeople[person] = hashSetOf()
                }
                distinctPeople[person]!!.add(group)
            }
        }
        val group1 = hashSetOf<Int>()
        val group2 = hashSetOf<Int>()
        for (person in distinctPeople.keys){
            if (group1.contains(person) || group2.contains(person)){
                continue
            }
            val group = distinctPeople[person]!!
            val group1Size = group1.size
            val group2Size = group2.size
            for (g in group){
                if (g.any { group1.contains(it) }){
                    group2.add(person)
                } else {
                    group1.add(person)
                }
            }
            if (group1.size == group1Size && group2.size == group2Size){
                group1.add(person)
            }
        }
        return (group1.size + group2.size) == n
    }
    @Test
    fun test(){
        assert(possibleBipartition(4, arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,4))) == true)
        assert(possibleBipartition(3, arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,3))) == false)
        assert(possibleBipartition(5, arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5), intArrayOf(1,5))) == false)
    }

}