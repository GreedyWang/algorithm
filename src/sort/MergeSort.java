package sort;

import java.util.Arrays;

/**
 * Created by wangyongmin on 2018/4/16.
 */
public class MergeSort {
    private static void sort(int[] a) {
        if (a.length > 1) {
            mergeSort(a, 0, a.length -1);
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) >> 1;
        mergeSort(a, left, middle);
        mergeSort(a, middle + 1, right);
        merge(a, left, middle, right);
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[a.length];
        int mid = middle + 1;
        int i = left;
        int tmp = left;
        while (left <= middle && mid <= right) {
            if (a[left] <= a[mid]) {
                tmpArr[i++] = a[left++];
            } else {
                tmpArr[i++] = a[mid++];
            }
        }

        while (mid <= right) {
            tmpArr[i++] = a[mid++];
        }
        while (left <= middle) {
            tmpArr[i++] = a[left++];
        }
        while (tmp <= right) {
            a[tmp] = tmpArr[tmp++];
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 8, 5, 2, 1, 3, 4, 9, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
