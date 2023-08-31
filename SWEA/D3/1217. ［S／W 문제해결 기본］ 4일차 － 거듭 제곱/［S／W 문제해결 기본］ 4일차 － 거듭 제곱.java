import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int result = recursive_power(N, M);

			System.out.println("#" + tc + " " + result);
		}
	}// main end

	public static int recursive_power(int n, int m) {
		int y;
		if (m == 1)
			return n;
		if (m % 2 == 0) {
			y = recursive_power(n, m / 2);
			return y * y;
		} else {
			y = recursive_power(n, (m - 1) / 2);
			return y * y * n;
		}
	}
}
