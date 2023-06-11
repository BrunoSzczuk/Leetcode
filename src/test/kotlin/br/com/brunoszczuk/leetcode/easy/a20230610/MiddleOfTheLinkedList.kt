package br.com.brunoszczuk.leetcode.easy.a20230610

import org.junit.jupiter.api.Test

class MiddleOfTheLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        var mid: ListNode? = head
        var end: ListNode? = head

        while (end?.next != null) {
            mid = mid?.next
            end = end.next?.next
        }

        return mid
    }


    @Test
    fun middleNodeTest() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val returnValue = middleNode(node1)
        println("returnValue = ${returnValue?.`val`}")
        assert(returnValue?.`val` == 3)
    }

    @Test
    fun middleNodeTest2() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6

        val returnValue = middleNode(node1)
        println("returnValue = ${returnValue?.`val`}")
        assert(returnValue?.`val` == 4)
    }
}