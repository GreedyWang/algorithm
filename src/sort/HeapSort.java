package sort;

/**
 * Created by wangyongmin on 2018/4/13.
 * http://www.icourse163.org/learn/ZJU-93001?tid=1002654021#/learn/content
 */
public class HeapSort {

    public static void sortHeap(int[] a) {

        //建立大顶堆

        buildMaxHeap(a);

        for (int i = a.length - 1; i > 0; i--) {

            //将大顶堆的最大值，也就是数组中的第一个元素移到最尾部，之后就不管了

            int temp = a[i];

            a[i] = a[0];

            a[0] = temp;

            //由于根节点与叶子节点互换，此时需要再次对根节点进行大顶堆操作，就这样依次循环

            heapAdjust(a, 0, i);

        }

    }

    private static void buildMaxHeap(int[] a) {

        int n = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapAdjust(a, i, n);
        }

    }

    private static void heapAdjust(int[] k, int s, int n) {
        int parent = k[s];
        for (int i = 2 * s; i < n; i *= 2) {
            if (i + 1 < n && k[i] < k[i + 1]) {
                i++;
            }

            if (parent >= k[i]) {
                break;
            }
            k[s] = k[i];
            s = i;
        }
        k[s] = parent;
    }


    public static void main(String[] args) {

        int[] a = {12, 23, 14, 6, 3, 54};

        sortHeap(a);

        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i] + " ");

        }

    }


}
