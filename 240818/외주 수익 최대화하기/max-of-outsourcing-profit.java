import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        int[][] allowance = new int[n][2];
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int time = Integer.parseInt(tokenizer.nextToken());
			int pay = Integer.parseInt(tokenizer.nextToken());
			
			allowance[i][0] = time;
			allowance[i][1] = pay;
		}
        
        for (int i = n - 1; i >= 0; i--) {
        	int time = allowance[i][0];
        	int pay = allowance[i][1];
			if (i + time <= n) {
				dp[i] = Math.max(dp[i + 1], pay + dp[i + time]);
			} else {
				dp[i] = dp[i + 1];
			}
		}
        
        System.out.println(dp[0]);
        reader.close();
    }
}