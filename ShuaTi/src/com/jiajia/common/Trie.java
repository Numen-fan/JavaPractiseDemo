package com.jiajia.common;

/**
 * Created by Numen_fan on 2022/9/18
 * Desc: 字典树 https://leetcode.cn/problems/sum-of-prefix-scores-of-strings/solution/by-darkbin-u22w/
 */
public class Trie {

    Trie[] children;
    boolean isEnd;

    // 扩展字段
    int num; // 用于记录当前前缀出现的次数

    public Trie() {
        children = new Trie[26];
        isEnd = false;
        num = 0;
    }

    public void insert(String word) {
        Trie node = this; // 根节点上，不做处理，应该从children节点上下手
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index]; // 这里相当于往下走了
            // 更新当前前缀出现的次数
            node.num++;
        }
        node.isEnd = true; // 说明根节点到这个节点的路径字符组成的字符串，是一个完整的字符串
    }

    /**
     * 搜索前缀次数
     * @param prefix
     * @return
     */
    public int searchPrefix(String prefix) {
        Trie node = this;
        int cnt = 0;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
                // 累加该单词所有前缀出现的次数
                cnt += node.num;
            } else {
                return 0;
            }
        }
        return cnt;
    }

}
