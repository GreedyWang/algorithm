package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Created by wangyongmin on 2018/4/16.
 */
public class QuickSort {

    private static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int middle;
        if (left < right) {
            middle = split(a, left, right);
            quickSort(a, left, middle -1 );
            quickSort(a, middle + 1, right);
        }
    }

    /**
     *
     * @param a
     * @param left
     * @param right
     * @return index of pivot
     */
    private static int split(int[] a, int left, int right) {

        int pivot = a[left];
        while (left < right) {
            while ( left < right && a[right] >= pivot) {
                right--;
            }
            if (left < right) {
                a[left++] = a[right];
            }
            while (left < right && a[left] <= pivot) {
                left++;
            }
            if(left < right) {
                a[right--] = a[left];
            }
        }
        a[left] = pivot;
        return left;
    }


    public static void main(String[] args) {
        int[] a = {7, 8, 5, 2, 1, 3, 4, 9, 6};
        quickSort(a, 0, a.length -1 );
        System.out.println(Arrays.toString(a));
    }

}
