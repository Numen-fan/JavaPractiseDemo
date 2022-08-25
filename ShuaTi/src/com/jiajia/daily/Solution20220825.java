package com.jiajia.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 658. 找到 K 个最接近的元素
 */
public class Solution20220825 {

    public static void main(String[] args) {
        Solution20220825 solution20220825 = new Solution20220825();

        System.out.println(solution20220825.findClosestElements(new int[]{0,1,2,2,2,3,6,8,8,9}, 5, 9));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> set = new ArrayList<>();

        int n = arr.length - 1;

        if(x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                set.add(arr[i]);
            }
        } else if(x >= arr[n]) {
            for (int i = n - k + 1; i <= n; i++) {
                set.add(arr[i]);
            }
        } else {
            int closeIndex = binarySearch(arr, x, 0, n);

            set.add(arr[closeIndex]); // 先加进去一个
            k--;

            // 从closeIndex向两边扩展
            int left = closeIndex - 1;
            int right = closeIndex + 1;

            while(k > 0) {
                while (k > 0 && left >= 0 && right <= n && x - arr[left] <= arr[right] - x) {
                    set.add(arr[left]);
                    k--;
                    left--;
                }

                while (k > 0 && right <= n && left >= 0 && x - arr[left] > arr[right] - x) {
                    set.add(arr[right]);
                    k--;
                    right++;
                }

                if (left < 0 || right > n) {
                    break;
                }
            }

            if (k > 0) {
                if (left >= 0) {
                    while (left >= 0 && k > 0) {
                        set.add(arr[left]);
                        k--;
                        left--;
                    }
                } else if (right <= n) {
                    while (right <= n && k > 0) {
                        set.add(arr[right]);
                        k--;
                        right++;
                    }
                }
            }
        }

        return set.stream().sorted().collect(Collectors.toList());

    }

    /**
     * 找到距离x最近的数的下标, 两种情况
     * arr[i] == x, return i
     * (x - arr[i - 1] <= arr[i] - x) return i - 1
     */
    private int binarySearch(int[] arr, int x, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) >> 1;
        if (arr[mid] == x) {
            return mid;
        }

        int index;
        if (arr[mid] > x) {
            index = binarySearch(arr, x, left, mid - 1);
        } else {
            index = binarySearch(arr, x, mid + 1, right);
        }

        if (index == -1) {
            // 说明x没在arr中, 这里还要分奇数还是偶数
            if (left != right) { // 偶数
                index = x - arr[left] <= arr[right] - x ? left : right;
            } else { // 奇数 left == right;
                if (arr[left] > x) {
                    // 和前一个比较
                    index = x - arr[left - 1] <= arr[left] - x ? left - 1 : left;
                } else {
                    // 和后一个比较
                    index = x - arr[left] <= arr[left + 1] - x ? left : left + 1;
                }
            }
        }

        return index;
    }
}
