import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()) / 10;

			int[] money = new int[] { 1, 5, 10, 50, 100, 500, 1000, 5000 };
			int[][] result = new int[8][N + 1]; // 금액별 거스름돈 개수를 센다.

			for (int i = 1; i <= N; i++) {
				int min = 987654321; 
				for (int j = 0; j < 8; j++) {
					if (i >= money[j]) { // 현재 돈이 거스름돈 값보다 클때 (안그럼 인덱스 에러)
						for (int k = 0; k < 8; k++) { // 거스름돈 종류만큼 돌면서 
							if (k == j) result[k][i] = result[k][i - money[j]] + 1; // 동전 개수 추가 
							else result[k][i] = result[k][i - money[j]]; // money[j] 거스름돈만큼 있기 이전에 거스름돈 개수  
						} 
					}
				} // 거스름돈 개수 나누기 완료
			} 
			System.out.println("#" + tc);
			for (int i = 7; i >= 0; i--) {
				System.out.print(result[i][N] + " ");
			} // 결과 출력
			System.out.println();
		} // test case end
	}// main end
}