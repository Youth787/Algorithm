import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//4 4
//0100
//0111
//1110
//0010

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		if (n == 1 && m == 1) { // 1x1 크기의 판이면 1출력하고 끝낸다.
			System.out.println(1);
			return;
		}

		int[][] dp = new int[n + 1][m + 1];

		int ans =0;
		
		for (int i = 1; i <= n; i++) {
			input = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				int temp = Integer.parseInt(input[j - 1]);
				if (i == 1 && j == 1) dp[i][j] = temp; // 1,1의 원소는 그 해당 값을 담는다. 
				else {
					if(temp==1) {
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
						ans = Math.max(dp[i][j], ans);
					}
				}
			}
		}
		System.out.println(ans*ans);
	}// main end
}
