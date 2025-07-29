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

        // dp[i][k]: number of ways to construct sum k using coins from index i to n-1
        // We'll use space optimization with two 1-D arrays:
        int[] nextState = new int[x + 1];
        nextState[0] = 1;  // dp[n][0] = 1 (base case)

        for (int i = n - 1; i >= 0; i--) {
            int[] currentState = new int[x + 1];
            currentState[0] = 1; // base case

            for (int sum = 1; sum <= x; sum++) {
                int skipping = nextState[sum];
                int picking = 0;
                if (a[i] <= sum) {
                    picking = currentState[sum - a[i]];
                }
                currentState[sum] = (skipping + picking) % MOD;
            }

            // Move to the next iteration
            nextState = currentState;
        }

        System.out.println(nextState[x]);
        sc.close();
    }
}
