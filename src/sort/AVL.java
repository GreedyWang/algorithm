package sort;

/**
 * Created by wangyongmin on 2018/4/16.
 */
public class AVL {

    Node root = null;

    public void insert(int a) {
        Node n = new Node(a);
        if (root == null) {
            root = n;
            return;
        }
        Node c = root;
        Node p = null;
        while(true) {
            p = c;
            if (a < c.value) {
                c = c.left;
                if (c == null) {
                    p.left = n;
                    return;
                }
            } else {
                c = c.right;
                if (c == null) {
                    p.right = n;
                    return;
                }
            }
        }
    }

    public void delete(int a) {

    }

    public int find(int a) {
        return 0;
    }

    public int findMin() {
        return 0;
    }

    public int findMax() {
        return -1;
    }

    //-------adjust methods-------
    private void rr() {

    }

    private void ll() {

    }

    private void lr() {

    }

    private void rl() {

    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 5, 2, 1, 3, 4, 9, 6};
        int i;
        AVL tree = new AVL();
        System.out.printf("== 依次添加: ");
        for(i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        System.out.printf("\n== 前序遍历: ");
        tree.preOrder();
    }

    private void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + "");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;
    int height;

    public Node(int v) {
        value = v;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}
