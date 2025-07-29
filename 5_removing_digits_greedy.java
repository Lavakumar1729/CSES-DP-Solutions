import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int steps = 0;
        
        while (n > 0) {
            String numStr = Integer.toString(n);
            char maximumDigit = '0';
            
            for (char ch : numStr.toCharArray()) {
                if (ch > maximumDigit) {
                    maximumDigit = ch;
                }
            }
            
            steps++;
            n -= (maximumDigit - '0');
        }
        
        System.out.println(steps);
        sc.close();
    }
}
