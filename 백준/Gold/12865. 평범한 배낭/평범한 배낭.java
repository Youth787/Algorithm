import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료

		dp = new int[N][K+1];
		System.out.println(bag(N - 1, K));

	}// main end

	public static int bag(int idx, int k) {
		if(idx<0)
			return 0;
		
		if (dp[idx][k] == 0) {
			if (arr[idx][0] > k)
				dp[idx][k] = bag(idx - 1, k);
			else 
				dp[idx][k] = Math.max(bag(idx-1,k),bag(idx-1,k-arr[idx][0])+arr[idx][1]);
		}
		return dp[idx][k];
	}
}
