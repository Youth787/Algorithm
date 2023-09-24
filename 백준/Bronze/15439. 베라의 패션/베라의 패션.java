import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1)
			System.out.println(0);
		else {
			int result = ncr(N, 2);
			System.out.println(result * 2);
		}
	}

	public static int ncr(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return ncr(n - 1, r - 1) + ncr(n - 1, r);
	}
}
