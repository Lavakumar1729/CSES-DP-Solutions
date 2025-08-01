import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume the trailing newline
        
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        int[] nextRow = new int[n];

        // Base case for the destination cell
        if (arr[n - 1].charAt(n - 1) == '.')
            nextRow[n - 1] = 1;
        else
            nextRow[n - 1] = 0;

        // Fill the last row from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[n - 1].charAt(i) == '.')
                nextRow[i] = nextRow[i + 1];
            else
                nextRow[i] = 0;
        }

        // Compute the rest of the grid from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            int[] currentRow = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1)
                    continue;
                if (arr[i].charAt(j) == '*') {
                    currentRow[j] = 0;
                } else {
                    int ans1 = (i < n - 1) ? nextRow[j] : 0;
                    int ans2 = (j < n - 1) ? currentRow[j + 1] : 0;
                    currentRow[j] = (ans1 + ans2) % MOD;
                }
            }
            nextRow = currentRow;
        }

        System.out.println(nextRow[0]);
        sc.close();
    }
}
