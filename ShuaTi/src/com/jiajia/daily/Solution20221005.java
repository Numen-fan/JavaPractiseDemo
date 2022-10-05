package com.jiajia.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Numen_fan on 2022/10/5
 * Desc: 811
 */
public class Solution20221005 {

    public static void main(String[] args) {
        subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int idx = cpdomain.indexOf(" ");
            int cnt = Integer.parseInt(cpdomain.substring(0, idx));
            String[] domains = cpdomain.substring(idx + 1).split("\\."); // 注意
            for (int i = 0; i < domains.length; i++) {
                StringBuilder sb = new StringBuilder(domains[i]);
                for (int j = i + 1; j < domains.length; j++) {
                    sb.append(".").append(domains[j]);
                }
                int originCnt = map.getOrDefault(sb.toString(), 0);
                map.put(sb.toString(), originCnt + cnt);
            }
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }

        return ans;
    }
}
