package br.com.brunoszczuk.leetcode.easy._2024_05_22

import org.junit.jupiter.api.Test

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString() : String{
        return `val`.toString()
    }
}

class `Remove Duplicates from Sorted List` {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null){
            return null
        }
        var node: ListNode? = head.next
        var before: ListNode = head
        while (node != null) {
            if (node.`val` == before.`val`) {
                before.next = node.next
            }else{
                before = node
            }
            node = node.next
        }
        return head
    }

    @Test
    fun test() {
        assert(deleteDuplicates(ListNode(1))?.`val` == 1)

        val head = ListNode(1)
        head.next = ListNode(1)
        head.next?.next = ListNode(2)
        head.next?.next?.next = ListNode(3)
        head.next?.next?.next?.next = ListNode(3)
        val node = deleteDuplicates(head)
        assert(node?.`val` == 1)
        assert(node?.next?.`val` == 2)
        assert(node?.next?.next?.`val` == 3)
        assert(node?.next?.next?.next == null)

    }

}

