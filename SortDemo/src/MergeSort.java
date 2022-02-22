import java.util.Arrays;
/**
 * Created by Numen_fan on 2021/01/10
 * desc: 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, 3, 4, 6, 8, 0, -2, 5};
        System.out.println(Arrays.toString(mergeSort(arr)));

        String str = "啊我是测试测试是我我是测试";
        System.out.println(str.substring(0,10) + "…");

        String str1 = "ABCD\t123\n\\\101";
        System.out.println(str1.length());

    }

    /**
     * 采用递归处理
     * (分解)
     */
    private static int[] mergeSort(int[] sourceArr) {
        if (sourceArr.length < 2) { // 这里处理递归结束条件，当被拆解到只有一个元素时，一个元素必定有序
            return sourceArr;
        }
        int mid = sourceArr.length / 2;
        // 将sourceArr拆分成左右两部分
        int[] left = Arrays.copyOfRange(sourceArr, 0, mid); // 不包含mid处的元素
        int[] right = Arrays.copyOfRange(sourceArr, mid, sourceArr.length);
        // 合并"排序后"的左右部分
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 归并两个"有序"的数组
     * @return 合并后的新的数组
     */
    private static int[] merge(int[] arr1, int[] arr2) {
        // 1 处理边界情况
        if (arr1 == null || arr1.length == 0) {
            return arr2 == null || arr2.length == 0 ? null : arr2;
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }

        int[] resArr = new int[arr1.length + arr2.length];
        int resIndex = 0; // resArr的下标
        int arr1Index = 0;
        int arr2Index = 0;
        // 2 做合并
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            resArr[resIndex++] = arr1[arr1Index] <= arr2[arr2Index] ?
                    arr1[arr1Index++] : arr2[arr2Index++]; // 三个下标做自加
        }
        // 3 处理剩余的数组（这里需要清楚，arr1Index或者arr2Index是对应数组中还没有处理的元素下标）
        if (arr1Index < arr1.length) {
            System.arraycopy(arr1, arr1Index, resArr, resIndex, arr1.length - arr1Index);
        }
        if (arr2Index < arr2.length) {
            System.arraycopy(arr2, arr2Index, resArr, resIndex, arr2.length - arr2Index);
        }
        return resArr;
    }

}
