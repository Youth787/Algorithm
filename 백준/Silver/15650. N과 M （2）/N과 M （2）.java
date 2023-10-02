import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		NCR(0, 0);

	}// main end

	static void NCR(int depth, int idx) {
		if (depth == M) {
			for (int a : result)
				System.out.print(a + " ");
			System.out.println();
			return;
		}
		
		if(idx==N) 
			return;

		result[depth] = idx + 1;
		NCR(depth + 1, idx + 1);
		NCR(depth, idx + 1);
	}// method end
}
