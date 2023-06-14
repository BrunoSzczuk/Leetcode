package br.com.brunoszczuk.leetcode.medium.a20230611

import org.junit.jupiter.api.Test

class SwappingNodesInALinkedList {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun swapNodesGoingFaster(head: ListNode?, k: Int): ListNode? {
        var node = head
        for (i in 1 until k){
            node = node?.next
        }
        val firstNode = node
        var lastNode = head
        while(node?.next != null ){
            node = node.next
            lastNode = lastNode?.next
        }
        firstNode!!.`val` = lastNode!!.`val`.also { lastNode.`val` = firstNode.`val` }

        return head
    }

    fun swapNodesDelayed(head: ListNode?, k: Int): ListNode? {
        var node = head
        var count = 0
        var firstNode: ListNode? = null
        var secondNode: ListNode? = null
        while (node != null) {
            count++
            if (secondNode != null) {
                secondNode = secondNode.next
            }
            if (count == k) {
                firstNode = node
                secondNode = head
            }
            node = node.next
        }
        val temp = firstNode?.`val`
        firstNode?.`val` = secondNode?.`val`!!
        secondNode.`val` = temp!!
        return head
    }

    @Test
    fun swapNodesTest() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val returnValue = swapNodesGoingFaster(node1, 2)
        println("returnValue = ${returnValue?.`val`}")
        assert(returnValue?.`val` == 1)
    }

    @Test
    fun swapNodesTest2() {
        val node1 = ListNode(7)
        val node2 = ListNode(9)
        val node3 = ListNode(6)
        val node4 = ListNode(6)
        val node5 = ListNode(7)
        val node6 = ListNode(8)
        val node7 = ListNode(3)
        val node8 = ListNode(0)
        val node9 = ListNode(9)
        val node10 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = node8
        node8.next = node9
        node9.next = node10

        val returnValue = swapNodesGoingFaster(node1, 5)
        println("returnValue = ${returnValue?.`val`}")
        assert(returnValue?.`val` == 4)
    }

    @Test
    fun swapNodesTest3(){
        val node1 = ListNode(100)
        val node2 = ListNode(90)
        node1.next = node2
        val returnValue = swapNodesGoingFaster(node1, 2)
        println("returnValue = ${returnValue?.`val`}")
        assert(returnValue?.`val` == 90)
    }
}