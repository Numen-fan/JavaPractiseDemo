package com.jiajia.hot100

import com.jiajia.common.KotlinListNode

/**
 * 146. LRU 缓存
 */
class Hot146Important(capacity: Int) {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot146Important(2)
            // [[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
            h.put(1,0)
            h.put(2,2)
            h.get(1)
            h.put(3,3)
            h.get(2)
            h.put(4,4)
            h.get(1)
            h.get(3)
            h.get(4)
        }
    }


    // 虚拟头尾节点
    var head: KotlinListNode = KotlinListNode()
    private var tail:KotlinListNode = KotlinListNode()

    // 快速查找节点
    val map = HashMap<Int, KotlinListNode>(capacity)
    var count = 0
    init {
        count = capacity
        head.tail = tail
        tail.head = tail
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        // 移动到第一个节点
        moveToFirst(node)
        println(head)
        return node.value
    }

    fun put(key: Int, value: Int) {
        var node = map[key]
        // 已经存在的节点
        if (node != null) {
            node.value = value
            moveToFirst(node)
            return
        }

        // 需要新增节点
        if (map.size >= count) {
            val removeNode = removeLast() // 这个removeNode的key是多少
            // 还需要从map中移除 【这里应该新建一个节点，将key和value都存起来】
            for ((k,v) in map) {
                if (v == removeNode) {
                    map.remove(k)
                    break
                }
            }
        }
        node = KotlinListNode(value)
        addToFirst(node)
        map[key] = node
        println(head.toString())
    }

    private fun addToFirst(node: KotlinListNode) {
        node.head = head
        node.tail = head.tail
        head.tail?.head = node
        head.tail = node
    }

    private fun moveToFirst(node: KotlinListNode) {
        // 先要移除node
        node.head?.tail = node.tail
        node.tail?.head = node.head
        // 移动到头结点
        head.tail?.head = node
        node.tail = head.tail
        node.head = head
        head.tail = node
    }

    private fun removeLast(): KotlinListNode {
        val node = tail.head // 被移除的节点
        tail.head?.head?.tail = tail
        tail.head = tail.head?.head
        return node!!
    }
}