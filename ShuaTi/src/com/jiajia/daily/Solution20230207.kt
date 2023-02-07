package com.jiajia.daily

/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 */
class Solution20230207 {

    fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
        val map = HashMap<String, ArrayList<String>>()
        for (i in keyName.indices) {
            map.putIfAbsent(keyName[i], ArrayList())
            var list: ArrayList<String> = map.get(keyName[i])!!
            list.add(keyTime[i])
        }
        var ansList = ArrayList<String>()
        // 过滤掉不可能满足的数据
        map.filter { (_, value) -> value.size >= 3 }

        // 遍历剩余的数据
        for ((key, value) in map) {
            value.sort() // 将时间进行排序
            for (i in 2 until value.size) {
                val pre = value[i - 2]
                val cur = value[i]
                // 判断cur和pre是否在一个小时以内
                if (inAnHour(pre, cur)) {
                    ansList.add(key)
                    break // 不需要再继续找了
                }
            }
        }
        ansList.sort()
        return ansList
    }

    private fun inAnHour(pre: String, cur: String): Boolean {
        val arr1 = pre.split(":")
        val timePre = arr1[0].toInt() * 60 + arr1[1].toInt()
        val arr2 = cur.split(":")
        val timeCur = arr2[0].toInt() * 60 + arr2[1].toInt()
        return timeCur - timePre <= 60
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230207()
            s.alertNames(
                listOf("daniel", "daniel", "daniel", "luis", "luis", "luis", "luis").toTypedArray(),
                listOf("10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00").toTypedArray()
            )
        }
    }

}