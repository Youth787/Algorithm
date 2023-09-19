import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] pay = new int[4];
	static int[] year= new int[12];
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				pay[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				year[i] = Integer.parseInt(st.nextToken());
			} // 입력받기 완료
			
			result = pay[3];
			DFS(0, 0);

			System.out.println("#" + tc + " " + result);
		} // test case end
	}// main end

	public static void DFS(int idx, int sum) {
		if (sum >= result)
			return;
		
		if (idx >= 12) {
			result = Math.min(result, sum);
			return;
		}
			DFS(idx + 3, sum + pay[2]);
			DFS(idx + 1, sum + pay[1]);
			DFS(idx + 1, sum + pay[0] * year[idx]);
	}
}
