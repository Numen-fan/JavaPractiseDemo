import java.util.Arrays;

public class ShellSortDemo {

    public static void main(String[] args) {
        int[] arr = {15,37,1,2,3,7,10,11,12,13,39,42,67,20,57,65,38,36,4};
        System.out.println(Arrays.toString(shellSort(arr)));

//        int[] packageArr = {};
//        System.out.println(packageArr.length);
    }

    /**
     * 希尔排序(升序)
     * @param arr 待排序数组
     */
    public static int[] shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int gap = arr.length / 2; gap > 0; gap /= 2) { // 控制希尔增量
            for (int i= gap; i < arr.length; i++) { // 按照希尔增量进行分组
                for (int j = i - gap; j >= 0; j -= gap) { // 对每个分组进行插入排序
                    // 每次向前探索gap个距离，如果gap=1，则每次比较前一个，即简单插入排序。
                    if (arr[j] > arr[j + gap]) {
                        swap(arr, j, j + gap);
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 交换数组中两个元素
     */
    public static void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
