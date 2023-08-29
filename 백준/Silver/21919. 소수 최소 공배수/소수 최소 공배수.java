import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		행복이는 길이가 N인 수열에서 소수들을 골라 최소공배수를 구해보려고 한다.
//		행복이를 도와 이를 계산해주자.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (isprime(n) && !list.contains(n))
				list.add(n);
		}

		long result = 1;
		if (list.size() == 0) {
			System.out.print("-1");
		} else {
			for (int i = 0; i < list.size(); i++)
				result *= list.get(i);
			System.out.print(result);
		}

	}// main

	public static boolean isprime(int n) {
		if (n <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}// method end
}
