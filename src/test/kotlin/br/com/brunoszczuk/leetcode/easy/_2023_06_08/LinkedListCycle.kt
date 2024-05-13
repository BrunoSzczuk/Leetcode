package br.com.brunoszczuk.leetcode.easy._2023_06_08

import org.junit.jupiter.api.Test

class LinkedListCycle {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    fun hasCycle(head: ListNode?): Boolean {

        var previous = head
        var next = head?.next
        while (previous != null && next != null) {
            if (previous == next) return true
            previous = previous.next
            next = next.next?.next
        }
        return false
    }

    @Test
    fun hasCycleTestCase1() {
        val node1 = ListNode(3)
        val node2 = ListNode(2)
        val node3 = ListNode(0)
        val node4 = ListNode(-4)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node2
        val returnValue = hasCycle(node1)
        println("returnValue = ${returnValue}")
        assert(returnValue)
    }
}

