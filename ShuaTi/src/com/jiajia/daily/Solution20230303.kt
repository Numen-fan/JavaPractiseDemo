package com.jiajia.daily

/**
 * 1487. 保证文件名唯一
 */
class Solution20230303 {

    fun getFolderNames(names: Array<String>): Array<String> {
        val len = names.size
        val ans = Array(len) { "" }
        val map = HashMap<String, Int>() // value 是key出现的下次应该拼几
        for (i in names.indices) {
            val name = names[i]
            if (!map.containsKey(name)) {
                ans[i] = name
            } else {
                // 重复了, 需要拼接
                var cnt = map[name]!!
                while (map.containsKey("$name($cnt)")) {
                    cnt++
                }
                map[name] = cnt // 修改这个name下次应该拼几，关键
                ans[i] = "$name($cnt)"
            }
            map[ans[i]] = 1
        }
        return ans
    }

}