import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			char[][] flag = new char[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++)
					flag[i][j] = s.charAt(j);
			} // 입력 받기 완료
			
			int min =Integer.MAX_VALUE;
			for (int i = 0; i < N - 2; i++) {// white
				for (int j = 1 + i; j < N - 1; j++) {// blue
					int white = 0;
					int blue = 0;
					int red = 0;
					
					for (int k = 0; k < M; k++) { // 열 방향 동일 
						for (int w = 0; w <= i; w++) 
							if (flag[w][k] == 'W')
								white ++;
						for (int b = i + 1; b <= j; b++) 
							if (flag[b][k] == 'B')
								blue ++;
						for (int r = j + 1; r < N; r++) 
							if (flag[r][k] == 'R')
								red ++;
					}// 열방향 for 
						int sum = white+blue+red;
						sum = N*M - sum;
						min = Math.min(min, sum);
				}// j end 
			}// i end 
			sb.append("#"+tc+" "+min+"\n");
		} // test case end
		System.out.print(sb);
	}// main end
}
