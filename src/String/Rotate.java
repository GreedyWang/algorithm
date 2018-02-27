package String;

import com.sun.tools.javac.util.Assert;

/**
 * 题目描述
 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。

 Answer:
 三步反转法
 对于这个问题，换一个角度思考一下。
 将一个字符串分成X和Y两个部分，在每部分字符串上定义反转操作，如X^T，即把X的所有字符反转（如，X="abc"，那么X^T="cba"），那么就得到下面的结论：(X^TY^T)^T=YX，显然就解决了字符串的反转问题。
 例如，字符串 abcdef ，若要让def翻转到abc的前头，只要按照下述3个步骤操作即可：
 首先将原字符串分为两个部分，即X:abc，Y:def；
 将X反转，X->X^T，即得：abc->cba；将Y反转，Y->Y^T，即得：def->fed。
 反转上述步骤得到的结果字符串X^TY^T，即反转字符串cbafed的两部分（cba和fed）给予反转，cbafed得到defabc，形式化表示为(X^TY^T)^T=YX，这就实现了整个反转。

 */
public class Rotate {

    public static String rotate(char[] ctx, int i) {
        reverse(ctx, 0, i -1 );
        reverse(ctx, i, ctx.length - 1);
        reverse(ctx, 0, ctx.length - 1);
        return String.valueOf(ctx);
    }

    private static void reverse(char[] ctx, int from, int to) {
        while(from < to) {
            char tmp = ctx[from];
            ctx[from++] = ctx[to];
            ctx[to--] = tmp;
        }
    }

    public static void main(String[] args) {
        String result = rotate(new char[]{'a','b','c','d','e','f'}, 3);
        System.out.println(result);
        Assert.check(result.equals("defabc"));
    }
}
