import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;
	static StringBuilder sb;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		DFS(0);
		
		bw.flush();
		bw.close();
	}// main end

	public static void DFS(int depth) throws IOException {
		if (depth == M) {
			for (int a : result)
				bw.write(a + " ");
			bw.newLine();
			return;
		} // 기저파트 end

		for (int i = 0; i < N; i++) {
			result[depth] = i + 1;
			DFS(depth+1);
		}
	}// method end
}
