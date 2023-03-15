package com.jiajia.daily

class Solution20230313 {

    fun minNumberOfHours(initialEnergy: Int, initialExperience: Int, energy: IntArray, experience: IntArray): Int {
        var ans = 0
        var totalEnergy = initialEnergy
        var totalExperience = initialExperience
        for (i in energy.indices) {
            // 先看精力需要训练多长时间
            totalEnergy -= energy[i]
            if (totalEnergy <= 0) {
                ans += -totalEnergy + 1 // 要严格大于
                totalEnergy = 1 // 训练后恢复
            }
            // 在看经验需要训练多长时间
            if (totalExperience <= experience[i]) {
                val diff = experience[i] - totalExperience + 1
                totalExperience += diff // 累加这几小时的经验
                ans += diff
            }
            totalExperience += experience[i]
        }
        return ans
    }

}