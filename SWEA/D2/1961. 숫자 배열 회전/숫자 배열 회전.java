import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] array;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			array = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					array[i][j] = Integer.parseInt(st.nextToken());
			} // 입력 받기 완료
			
			sb = new StringBuilder();
			sb.append("#" + tc + " " + "\n");
			int i = 0;
			int j = N - 1;
			int k = N - 1;
			
			while (i < N && j >= 0 && k >= 0) {
				change90(i);
				change180(j);
				change270(k);
				i++; j--; k--;
				sb.append("\n");
			}
			System.out.print(sb);
		} // test case end
	} // main end

	public static void change90(int i) {
		for (int p = N - 1; p >= 0; p--)
			sb.append(array[p][i]);
		sb.append(" ");
	}
	public static void change180(int j) {
		for (int p = N - 1; p >= 0; p--)
			sb.append(array[j][p]);
		sb.append(" ");
	}
	public static void change270(int k) {
		for (int p = 0; p < N; p++)
			sb.append(array[p][k]);
		sb.append(" ");
	}
}
