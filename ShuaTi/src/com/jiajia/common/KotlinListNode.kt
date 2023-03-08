package com.jiajia.common

import java.lang.StringBuilder

class KotlinListNode {
    var head: KotlinListNode? = null
    var tail: KotlinListNode? = null
    var value = 0

    public constructor()

    public constructor(v: Int) : this() {
        this.value = v
    }

    override fun toString(): String {
        val sb = StringBuilder("[")
        var node:KotlinListNode? = this
        while (node != null) {
            sb.append(node.value).append(",")
            node = node.tail
        }
        sb.append("]")
        return sb.toString()
    }
}