package br.com.brunoszczuk.leetcode.medium._2024_05_11

import org.junit.jupiter.api.Test

class RemoveZeroSumConsecutiveNodesfromLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        if (head == null){
            return null
        }
        val novo = ListNode(0)
        novo.next = head
        var node : ListNode? = novo
        while(node?.next != null){
            var sum = 0
            var iterator = node.next
            while (iterator!= null){
                sum += iterator.`val`
                if (sum == 0){
                    node.next  = iterator.next
                }
                iterator = iterator.next
            }
            node = node.next
        }
        return novo.next
    }


    @Test
    fun testAll(){
        test1()
        test2()
        test3()
    }

    @Test
    //Input: head = [1,2,-3,3,1]
    //Output: [3,1]
    //Note: The answer [1,2,1] would also be accepted.
    fun test1(){
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(-3)
        val node4 = ListNode(3)
        val node5 = ListNode(1)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val result = removeZeroSumSublists(node1)
        assert(result?.`val` == 3)
        assert(result?.next?.`val` == 1)
    }

    //Input: head = [1,2,3,-3,4]
    //Output: [1,2,4]
    @Test
    fun test2(){
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(-3)
        val node5 = ListNode(4)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val result = removeZeroSumSublists(node1)
        assert(result?.`val` == 1)
        assert(result?.next?.`val` == 2)
        assert(result?.next?.next?.`val` == 4)
    }


    @Test
    //Input: head = [1,2,3,-3,-2]
    //Output: [1]
    fun test3(){
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(-3)
        val node5 = ListNode(-2)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val result = removeZeroSumSublists(node1)
        assert(result?.`val` == 1)
    }

}