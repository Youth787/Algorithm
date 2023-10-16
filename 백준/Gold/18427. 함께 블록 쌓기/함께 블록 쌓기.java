import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int H = Integer.parseInt(input[2]);
		int[][] dp = new int[N+1][H+1];
		
		ArrayList<Integer>[] list = new ArrayList[N+1];

		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			input = br.readLine().split(" ");
			
			for(int j=0; j<input.length; j++) {
				list[i].add(Integer.parseInt(input[j]));
			}
		}// 입력받기 완료 
		
//		for(int i=0; i<N; i++) {
//			list[i] = new ArrayList<>();
//			st = new StringTokenizer(br.readLine());
//			while(st.hasMoreTokens()) {
//				list[i].add(Integer.parseInt(st.nextToken()));
//			}
//		}// 입력받기 2 완료 

		// 0일 가능성은 모두 1
		for(int i=0; i<=N; i++) dp[i][0] = 1;
		
		 for(int i=1; i<=N; i++) {
	            for(int j=1; j<=H; j++) {
	                
	                for(int x : list[i]) {
	                    if(j>=x) {
	                        dp[i][j] += dp[i-1][j-x] % 10007;  //해당 블록을 쌓을수 있는 경우 더해줌
	                    }
	                }
	                dp[i][j] += dp[i-1][j] % 10007;  //블록을 안쌓을 경우
	            }
	        }
	        System.out.println(dp[N][H]%10007);
	    }
	}
