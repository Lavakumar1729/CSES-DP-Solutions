import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // A list to hold dp states, initially dp[0] = 1
        LinkedList<Integer> prev = new LinkedList<>();
        prev.add(1); 

        for (int i = 1; i <= n; i++) {
            int current = 0;
            for (int val : prev) {
                current = (current + val) % MOD;
            }

            prev.add(current);
            if (prev.size() > 6) {
                prev.removeFirst();
            }
        }

        // The last element of prev contains dp[n]
        System.out.println(prev.getLast());
        sc.close();
    }
}
