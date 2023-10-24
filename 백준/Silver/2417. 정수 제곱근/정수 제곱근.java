import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long n, result=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());

		binarySearch();
		System.out.println(result);

	}// main end

	public static void binarySearch() {
		long st = 0;
		long ed = n;

		while (st <= ed) {
			long mid = (st + ed) / 2;

			if (Math.pow(mid, 2)>= n) { //n*n 하면 값이 달라진다. 
				//n*n 정수 연산을 하기 때문에 정수 오버플로우가 발생. 
				result = mid;
				ed = mid - 1;
			} else 
				st = mid + 1;
		}
	}
}
