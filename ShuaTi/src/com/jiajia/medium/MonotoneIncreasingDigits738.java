package com.jiajia.medium;

public class MonotoneIncreasingDigits738 {

    public static void main(String[] args) {
        System.out.println(method2(332));

        for (int i = 2; i <= 9; i++) {
            System.out.println(getString(i));
        }
    }

    private static String getString(int num) {
        int len = num == 9 || num == 7 ? 4 :3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char)('a' + ((num - 2) * 3  + (num > 7 ? i + 1 : i))));
        }
        return sb.toString();
    }

    /**
     * 暴力求解1
     * 【Time Limit Exceeded】
     */
    private static int method1(int n) {
        int ans = 0;
        for(int i = n; i >= 0; i--) {
            String str = String.valueOf(i);
            int j = str.length() - 1;
            for(; j > 0; j--) {
                if(str.charAt(j) - str.charAt(j - 1) < 0) {
                    break;
                }
            }
            if (j == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 思想：
     * 从第一位开始遍历，如果后面有小于它的值，那么此位置就应该 - 1，
     * 【1】如果减1后，此位不为0，那么后面都是9。e.g. 332，第三位2比第一位小，则第一位变为2，后面为9，则为299。
     * 【2】如果减1后，此位变为0，那么后面的全部变为9，整体位数减1，比如10->9, 101->99
     */
    private static int method2(int n) {
        int ans = n;
        String str = String.valueOf(n); // 得到n对应的字符串
        for(int i = 0; i < str.length() - 1; i++) {
            int j = i + 1;
            boolean find = false;
            // 有优化的空间
            for(; j < str.length(); j++) {
                if (str.charAt(i) - str.charAt(j) > 0) {
                    find = true;
                    break;
                }
                // 说明j大于i，同步移动i。
                if (str.charAt(j) - str.charAt(j - 1) > 0) {
                    i = j;
                }
            }

            // 说明找到位置i后面比它小的数
            if (find) {
                if(str.charAt(i) - '1' > 0) { // i处数字减1，后面全是9
                    StringBuilder res = new StringBuilder(str.substring(0, i)); // 不包括i
                    res.append(str.charAt(i) - '1');
                    for(int k = 0; k < str.length() - i - 1; k++) {
                        res.append('9');
                    }
                    ans = Integer.parseInt(res.toString());
                } else { // i 处位置变为0，直接取后面的9999
                    StringBuilder res = new StringBuilder();
                    for (int k = 0; k < str.length() - 1; k++) {
                        res.append('9');
                    }
                    ans = Integer.parseInt(res.toString());
                }
                break;
            }
        }
        return ans;
    }

}
