import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B,ans;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			} // 입력받기 완료 
			
			ans = Integer.MAX_VALUE;
			powerset(0,0);
			System.out.println("#"+tc+" "+(ans-B));
		}//test case end 
	}// main end
	
	public static void powerset(int idx, int sum) {
		if(sum > ans) return;
		
		if(idx == N) {
			if(sum>=B) {
				ans  = Math.min(ans,sum);
			}
			return;
		}
		powerset(idx+1, sum+arr[idx]); // 쌓는다.
		powerset(idx+1, sum); // 쌓지 않는다. 
	}
}
