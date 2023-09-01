import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int win_count, lose_count, N, a, b;
	public static boolean[] visited, cards;
	static int[] cards_ku, cards_in, result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			cards_ku = new int[9];
			cards = new boolean[19];

			for (int i = 0; i < 9; i++) {
				cards_ku[i] = Integer.parseInt(st.nextToken());
				cards[cards_ku[i]] = true;
			} // 입력 받기 완료

			int n = 0;
			cards_in = new int[9];
			for (int i = 1; i < 19; i++) {
				if (!(cards[i])) {
					cards_in[n++] = i;
				}
			} // 인영의 카드가 담긴 배열 생성 완료.

			N = cards_in.length;
			result = new int[N];
			visited = new boolean[N];

			win_count = 0;
			lose_count = 0;
			perm(0);
			System.out.println("#" + tc + " " + win_count + " " + lose_count);
		} // test case end
	}// main end

	public static void perm(int idx) {
		if (idx == N) {
			int a = 0, b = 0;
			for (int i = 0; i < 9; i++) {
				if (result[i] > cards_ku[i]) a += result[i] + cards_ku[i];
				else if (result[i] < cards_ku[i]) b += result[i] + cards_ku[i];
			}
			if (a < b) win_count++;
			else if ( a > b) lose_count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue; 

			result[idx] = cards_in[i]; 
			visited[i] = true; 
			perm(idx + 1);
			visited[i] = false; 
		}
	}// method end 
}
