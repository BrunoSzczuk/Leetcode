package br.com.brunoszczuk.leetcode.easy._2024_05_22

import org.junit.jupiter.api.Test

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class `Binary Tree Postorder Traversal` {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null){
            return emptyList()
        }
        val list = mutableListOf<Int>()
        list.addAll(postorderTraversal(root.left))
        list.addAll(postorderTraversal(root.right))
        list.add(root.`val`)
        return list

    }

    @Test
    fun test() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right?.left = TreeNode(3)
        assert(postorderTraversal(root) == listOf(3, 2, 1))
    }
}