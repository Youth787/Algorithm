import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] array = new int[N];
			for (int i = 0; i < N; i++)
				array[i] = Integer.parseInt(st.nextToken());
			// 입력 받기 완료

			int max = array[N - 1];
			long sum = 0;
			for (int i = N - 2; i >= 0; i--) {
				if (max > array[i])
					sum += max - array[i];
				else
					max = array[i];
			}
			System.out.println("#" + tc + " " + sum);
		} // test case end
	}// main end
}
