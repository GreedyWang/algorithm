package dp;

/**
 * Created by wangyongmin on 16/11/14.
 */
public class Coins {

    private int coins[] = {1, 3, 5};
    static int[] dp = new int[101];

    public static void main(String args[]) {
        Coins c = new Coins();
        c.assgin(0, 100);
        for(int i=0;i<100;i++)
        {
            System.out.println("凑齐" + i +"元，至少需要" + dp[i] + "枚硬币");
        }
    }

    private void assgin(int i, int sum) {
        if (sum == 0) { dp[i] = 0; return;}
        if (i == 0) {
            dp[i] = 0;
            assgin(1, sum);
            return;
        } else {
            int MIN = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (i >= coins[j]) {
                    MIN = min(dp[i - coins[j]] + 1, MIN);
                }
            }
            dp[i] = MIN;
            if (i == sum) return;
            else
                assgin(i + 1, sum);
        }

    }

    int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
