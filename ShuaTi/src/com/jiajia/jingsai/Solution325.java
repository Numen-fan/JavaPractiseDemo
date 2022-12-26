package com.jiajia.jingsai;


import com.jiajia.kit.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution325 {

    public static void main(String[] args) {
        Solution325 s = new Solution325();

        System.out.println(s.closetTarget(new String[]{"aawyoesnjcwqruglyfcnpegnuldlwptcumkiphobxwuxyiwjlf","eaqdovsrujhtcicbfatmipvbwpbmlxanetmalajsfvdwovchtt","quwmjnluvdieyslkkzfvcezbapnpgpdpzeicxnsbxbdjyigogu","xwniqsgthhyrnaljcsbuljblwhyvinlrhcflqdonygyihcezoy","ozxpozhjxckidlryiuwpozxxzazegqwdpsghqpqsoxurwexgnx","quwmjnluvdieyslkkzfvcezbapnpgpdpzeicxnsbxbdjyigogu","chzkqmmgqwtqhdobgiupjqdaxjexhpjssucwtvkajrpazgbbst","chzkqmmgqwtqhdobgiupjqdaxjexhpjssucwtvkajrpazgbbst","beizsenkmlrqhbthcnglbkkysynbwljyxourgqxhhdbrqjwjbe","oooxxzyydbdjvhyhzvlwwlxbefmwbieadomipfvdmoujusdqnr","kgctiokinrfnnnxnbeetjcaswztgtljyisrbjojachfgbujxmn","aawyoesnjcwqruglyfcnpegnuldlwptcumkiphobxwuxyiwjlf","chmffhayhvjezcmcrrdzmtwfatovtesmeaysnaajwzpzktvkhy","xwniqsgthhyrnaljcsbuljblwhyvinlrhcflqdonygyihcezoy","hddpcgzsiixrorozrifikpweqvdfjlankmcunqajyawnpweqep","beizsenkmlrqhbthcnglbkkysynbwljyxourgqxhhdbrqjwjbe",
                "jzoeisnzvqaucssvezmedymvlvlivkuymirmjkaidwrfszmwey","quvrpqrtieoxatfruuininiunzyksoiirytfajdvskovglfyst","fquwwwuqddzzmghlsjkgntrdxcjjdhaturygnwpkqzurwhsnbs","ldimkhaogodsnggnncrlgqjhhrziqlipnpdnalobqtqomhivzb","gedkpyeefquljywyynyyloueewjukvvrflvzbqkslygbjxevln","hddpcgzsiixrorozrifikpweqvdfjlankmcunqajyawnpweqep","chzkqmmgqwtqhdobgiupjqdaxjexhpjssucwtvkajrpazgbbst","quwmjnluvdieyslkkzfvcezbapnpgpdpzeicxnsbxbdjyigogu","xosljdqelacotjmjykzqwfezqyqrzclwaxwnsshxqmfkkbxbsv","holorligkqqbwmuhtdxknbauoaapztgnvzspahmawfnguuxeet",
                "kgctiokinrfnnnxnbeetjcaswztgtljyisrbjojachfgbujxmn",
                "lnsxyyvxwktfrfcnaksfmjcylnuspghtibgobyzbcfndncfqkr",
                "xmmwhwqosxlboizfpjtqtjumqzkfbsqnalpgkhpqlpjyzqbhyn","jurfxnusubbwddfhkixdrtiktmkmdwteemopttiejxvvtdxody","beizsenkmlrqhbthcnglbkkysynbwljyxourgqxhhdbrqjwjbe","uvexttjbcqitczkkfdufmzltnzgrcjkiezbcdgrriehpdbsdno","beizsenkmlrqhbthcnglbkkysynbwljyxourgqxhhdbrqjwjbe","jzoeisnzvqaucssvezmedymvlvlivkuymirmjkaidwrfszmwey","ldnzxsgcpqgiozbbxdjxpgxnlighxtdljbpfjwbbimduusgeam","kgctiokinrfnnnxnbeetjcaswztgtljyisrbjojachfgbujxmn","qciwepmpfsthcshewvuavzditrhuyenwsmaobkvjlzzsunpbok","ozxpozhjxckidlryiuwpozxxzazegqwdpsghqpqsoxurwexgnx","qciwepmpfsthcshewvuavzditrhuyenwsmaobkvjlzzsunpbok",
                "aawyoesnjcwqruglyfcnpegnuldlwptcumkiphobxwuxyiwjlf","kyizgfbeppozaehswgeclpwgomayeujewtkgztdbdzalwfqclm","xmbxnviporjutaxljbfssthsxcagltaltpbvkjaairgauihead","ozxpozhjxckidlryiuwpozxxzazegqwdpsghqpqsoxurwexgnx","uvexttjbcqitczkkfdufmzltnzgrcjkiezbcdgrriehpdbsdno","ptbaikdzpyvjgqttnysohdujpjrkhmvpntmemjrpyewbqanmye","xosljdqelacotjmjykzqwfezqyqrzclwaxwnsshxqmfkkbxbsv","acfztjxiwvceveumejuvzkcpjkrdalaaobwzoystqbreeohirt","eaofhcezozzbrpaecxdccpbvdwvobcrfoizbuqzydburmybxli","wwbonwqbrtuhioyhtzkmqeprjkqzqcfmjxbkigbcsjxtuwfgmv","uwstockselmfmmxukqxjlfzjkkofkglcftenehhahqhjpeyoow"}, "qciwepmpfsthcshewvuavzditrhuyenwsmaobkvjlzzsunpbok", 5));

        System.out.println(s.maximumTastiness(ArrayUtils.string2IntArray("[13,5,1,8,21,2]"), 3));
    }

    public int closetTarget(String[] words, String target, int startIndex) {

        int leftIndex = startIndex;
        int rightIndex = startIndex + 1;
        int n = words.length;

        int ans = n;

        while (leftIndex >= 0 || rightIndex < n) {
            // 向左找
            if (leftIndex >= 0 && words[leftIndex].equals(target)) {
                ans = Math.min(ans, Math.min(startIndex - leftIndex, n - startIndex + leftIndex));
            }
            leftIndex--;

            // 向右找
            if (rightIndex < n && words[rightIndex].equals(target)) {
                ans =  Math.min(ans, Math.min(rightIndex - startIndex, startIndex + n - rightIndex));
            }
            rightIndex++;
        }

        return ans == n ? -1 : ans;
    }

    /**
     * 6270. 每种字符至少取 K 个
     * @param s
     * @param k
     * @return
     */
    public int takeCharacters(String s, int k) {
        int[] arr = new int[3];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        if (arr[0] < k || arr[1] < k || arr[2] < k) {
            return -1;
        }

        int ans = 0;

        int[] consume = new int[3];
        Arrays.fill(consume, k);

        int left = 0;
        int right = s.length() - 1;

        while (consume[0] > 0 || consume[1] > 0 || consume[2] > 0) {

        }

        return ans;
    }

    /**
     * 6271. 礼盒的最大甜蜜度
     * @param price
     * @param k
     * @return
     */

    int ans = 0;
    List<Integer> path = new ArrayList<>();

    public int maximumTastiness(int[] price, int k) {
        backTracing(price, 0, k);
        return ans;
    }

    private void backTracing(int[] price, int startIndex, int k) {
        if (path.size() == k) {
            // 计算这个path上值
            ans = Math.max(ans, getRes());
            return; // 结束这一次的递归
        }

        for (int i = startIndex; i < price.length; i++) {
            path.add(price[i]);
            backTracing(price, i + 1, k);
            // 回溯
            path.remove(path.size() - 1);
        }
    }

    /**
     * @return path中任意两个数的最小绝对值
     */
    private int getRes() {
        List<Integer> temp = new ArrayList<>(path);
        Collections.sort(temp);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size() - 1; i++) {
            ans = Math.min(ans, Math.abs(temp.get(i + 1) - temp.get(i)));
        }
        return ans;
    }
}
