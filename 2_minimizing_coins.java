import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int x = sc.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        int INF = (int)1e9;
        int[] dp = new int[x + 1];
        Arrays.fill(dp, INF);
        
        dp[0] = 0; // base case: 0 coins needed to make sum 0
        
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
                }
            }
        }
        
        System.out.println(dp[x] < INF ? dp[x] : -1);
        sc.close();
    }
}
