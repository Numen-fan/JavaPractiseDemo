package com.jiajia.sort;

import com.jiajia.kit.ArrayUtils;

/**
 * https://www.jianshu.com/p/1458abf81adf
 */
public class BubbleSort {

    private static final ThreadLocal<Integer> mThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        int[] arr = {2,5,1,3,8,5,7,4,3};
        bubbleSort(arr);
        ArrayUtils.print(arr);

        mThreadLocal.set(1);

        System.out.println(mThreadLocal.get());

        new Thread("Thread#1") {
            @Override
            public void run() {
                super.run();
                mThreadLocal.set(2);
                System.out.println(mThreadLocal.get());
            }
        }.start();

        new Thread("Thread#2") {
            @Override
            public void run() {
                super.run();
                System.out.println(mThreadLocal.get() == null ? "null" : mThreadLocal.get());
            }
        }.start();

    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] arr) {
        if(arr==null || arr.length < 2 ){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {   // 这里说明为什么需要-1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
