package br.com.brunoszczuk.leetcode.medium._2024_05_22

import br.com.brunoszczuk.leetcode.easy._2024_05_22.ListNode
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class `Reorder List` {

    fun reorderList(head: ListNode?) {

        if (head == null) {
            return
        }
        val queue = mutableListOf<ListNode>()
        var node = head.next
        while (node != null) {
            queue.add(node)
            node = node.next
        }
        var size = queue.size
        node = head
        while (size > 0) {
            node?.next = queue.removeAt(queue.size - 1)
            node = node?.next
            size--
            if (size > 0) {
                node?.next = queue.removeAt(0)
                node = node?.next
                size--
            }
        }
        node!!.next = null
    }



    @Test
    fun test() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next?.next = ListNode(3)
        head.next?.next?.next = ListNode(4)
        head.next?.next?.next?.next = ListNode(5)
        reorderList(head)
        assert(head.`val` == 1)
        assert(head.next?.`val` == 5)
        assert(head.next?.next?.`val` == 2)
        assert(head.next?.next?.next?.`val` == 4)
        assert(head.next?.next?.next?.next?.`val` == 3)
    }
}