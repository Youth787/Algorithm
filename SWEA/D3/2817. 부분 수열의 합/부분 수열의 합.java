
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int K;
	static int[] array;
	static int count;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			array = new int[N];
			boolean[] sel = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			} // 입력받기 완료

			StringBuilder sb = new StringBuilder();
			sum=0;
			count=0;
			powerset(0,sel);
			sb.append("#" + tc + " " + count);
			System.out.println(sb);
		} // test case end
	}// main end

	public static void powerset(int idx, boolean[] sel) {
		// 기저 파트
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum+=array[i];
				}
			}
			if (sum == K) {
				count++;
			}
			sum = 0;
			return;
		}

		// 재귀 파트
		sel[idx] = true;
		powerset(idx + 1, sel);
		sel[idx] = false;
		powerset(idx + 1,sel);
	}
}
