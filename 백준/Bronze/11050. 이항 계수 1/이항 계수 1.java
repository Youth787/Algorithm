import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

			int result = ncr(N, K);
			System.out.println(result);
	}

	public static int ncr(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return ncr(n - 1, r - 1) + ncr(n - 1, r);
	}
}
