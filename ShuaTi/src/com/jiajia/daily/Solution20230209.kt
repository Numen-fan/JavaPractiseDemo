package com.jiajia.daily

class Solution20230209(timeToLive: Int) {

    private val cacheMap: HashMap<String, Int> = HashMap()

    private var timeToLive: Int

    init {
        this.timeToLive = timeToLive
    }

    fun generate(tokenId: String, currentTime: Int) {
        cacheMap[tokenId] = currentTime
    }

    fun renew(tokenId: String, currentTime: Int) {
        val preTime = cacheMap.getOrDefault(tokenId, -1)
        if (preTime != -1 && currentTime - preTime < timeToLive) {
            cacheMap[tokenId] = currentTime
        }
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        var ans = 0
        for ((_, value) in cacheMap) {
            ans += if (currentTime - value < timeToLive) 1 else 0
        }
        return ans
    }
}