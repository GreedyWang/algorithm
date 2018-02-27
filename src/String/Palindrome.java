package String;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述
 回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我，这样的短句在智力性、
 趣味性和艺术性上都颇有特色，中国历史上还有很多有趣的回文诗。
 那么，我们的第一个问题就是：判断一个字串是否是回文？
 */
public class Palindrome {

    public static boolean isPalindrome(Node list) {
        //get the middle point for linked list
        Node cur = list;
        Node mid = list;
        while (cur.next != null && cur.next.next != null) {
            mid = mid.next;
            cur = cur.next.next;
        }
        System.out.println("found middle for list is: "+ mid.getData());
        //reverse the mid - end list
        Node reverseMid = reverseList(mid);
        reverseMid.display();
        //check the result
        while(reverseMid !=null){
            if (reverseMid.getData().equals(list.Data)) {
                reverseMid = reverseMid.next;
                list = list.next;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static Node reverseList(Node list) {
        Node head = list;

        Node pre = list;
        Node cur = list.getNext();
        Node tmp;
        while(cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;
    }

    public void testReverse() {
        Node n = new Node("a")
                .add(new Node("b"))
                .add(new Node("c"))
                .add(new Node("d"))
                .add(new Node("e"))
                .add(new Node("f"))
                .add(new Node("g"))
                ;
        n.display();
        Node t = reverseList(n);
        t.display();
    }

    public static void main(String[] args) {
        Node n = new Node("a")
                .add(new Node("b"))
                .add(new Node("c"))
                .add(new Node("d"))
               // .add(new Node("d"))
                .add(new Node("c"))
                .add(new Node("b"))
                .add(new Node("a"))
                ;
        n.display();
        boolean result = isPalindrome(n);
        System.out.println(result);
        Assert.that(result, "expect is true");
    }
}

class Node {
    public String Data;
    public Node next;
    int last = 0;

    public Node(String Data) {
        this.Data = Data;
    }

    /**
     * not safe
     * @param e
     * @return
     */
    public Node add(Node e) {
        Node t = this;
        int i = 0;
        while (i++ < last) {
            t = t.next;
        }
        t.next = e;
        last ++;
        return this;
    }


    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void display() {
        Node t = this;
        while(t != null) {
            System.out.print(t.Data + "->" );
            t = t.next;
        }

        System.out.println();
    }
}
