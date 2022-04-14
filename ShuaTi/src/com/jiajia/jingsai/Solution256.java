package com.jiajia.jingsai;

import java.util.*;

public class Solution256 {

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{9,4,1,7},2));

        System.out.println(kthLargestNumber(new String[]{"683339452288515879","7846081062003424420","4805719838",
                "4840666580043","83598933472122816064","522940572025909479","615832818268861533",
                "65439878015","499305616484085","97704358112880133","23861207501102","919346676",
                "60618091901581","5914766072","426842450882100996","914353682223943129","97",
                "241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"}, 3));



    }

    public static int minimumDifference(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int res = 1000000;
        for (int i = k - 1; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - k + 1]);
        }
        return res;
    }

    public static String kthLargestNumber(String[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        List<StringBean> stringList = new ArrayList<>();
        for (String num : nums) {
            try {
                numsList.add(Integer.parseInt(num));
            } catch (Exception e) {
                stringList.add(new StringBean(num));
            }
        }

        Collections.sort(numsList);
        Collections.sort(stringList);

        if (k <= stringList.size()) {
            return stringList.get(stringList.size() - k).toString();
        }

        k -= stringList.size();

        return String.valueOf(numsList.get(numsList.size() - k));
    }

    static class StringBean implements Comparable<StringBean> {

        String value;

        public StringBean(String val) {
            this.value = val;
        }

        @Override
        public int compareTo(StringBean o) {

            if (this == o || this.value.equals(o.value)) {
                return 0;
            }

            if (this.value.length() == o.value.length()) {
                return this.value.compareTo(o.value);
            }

            return this.value.length() - o.value.length();
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
