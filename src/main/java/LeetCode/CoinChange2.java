package LeetCode;

/*

给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */

//https://leetcode-cn.com/problems/coin-change-2/solution/518-ling-qian-dui-huan-iiwan-quan-bei-ba-ynjf/
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i < coin) continue;
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
