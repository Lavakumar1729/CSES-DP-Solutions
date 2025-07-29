import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1; // Base case: one way to make sum 0 (choose nothing)

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] <= i) {
                    dp[i] = (dp[i] + dp[i - a[j]]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
        sc.close();
    }
}
