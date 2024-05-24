package br.com.brunoszczuk.leetcode.easy._2024_05_22

import org.junit.jupiter.api.Test
import java.util.Stack
import kotlin.math.max
import kotlin.math.min

class `Minimum Depth of Binary Tree` {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null &&  root.right == null){
            return 1
        }
        if (root.left == null){
            return minDepth(root.right) + 1
        }
        if (root.right == null){
            return minDepth(root.left) +1
        }
        return minOf(minDepth(root.left), minDepth(root.right)) +1
    }

    @Test
    fun test() {
        //[2,null,3,null,4,null,5,null,6]
        val root = TreeNode(2)
        root.right = TreeNode(3)
        root.right?.right = TreeNode(4)
        root.right?.right?.right = TreeNode(5)
        root.right?.right?.right?.right = TreeNode(6)
        assert(minDepth(root) == 5)

    }
}