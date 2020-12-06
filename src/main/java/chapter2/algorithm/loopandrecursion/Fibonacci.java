package chapter2.algorithm.loopandrecursion;

public class Fibonacci {
    // 递归算法，但是效率很低，会有很多的重复运算
    public static int rFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return rFibonacci(n-1) + rFibonacci(n-2);
    }

    // 循环算法
    public static int lFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int pre = 1, prepre = 0, ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = pre + prepre;
            prepre = pre;
            pre = ans;
        }
        return ans;
    }

    // 还有一个小青蛙上台阶的问题
    // 一只青蛙一次可以跳上一级台阶和二级台阶，求该青蛙跳上n级台阶有多少种跳法
    // 设有 f(n) 种，其中第一次可以跳 1 级，那么剩余的次数就是 f(n-1),
    // 第一次也可以跳 2 级，那么剩余的次数就是 f(n-2)
    // 所以 f(n) = f(n-1) + f(n-2)  也是Fibonacci的求解
}
