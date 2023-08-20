import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		int start = N / 2;
		int n = 1; // 넣어줄 숫자
		int step = 1;
		int k = 0;
		map[start][start] = n++;
		int r = start;
		int c = start;
		while (n <= N * N) {
			for (int j = 0; j < 2; j++) {
				for (int p = 0; p < step; p++) {
					if (r + dir[k][0] >= 0 && r + dir[k][0] < N && c + dir[k][1] >= 0 && c + dir[k][1] < N
							&& map[r + dir[k][0]][c + dir[k][1]] == 0) {
						r = r + dir[k][0];
						c = c + dir[k][1];
						map[r][c] = n++;
					}
				}
				k = (k + 1) % 4;
			}
			step++;
		}

		int idx_r = 0;
		int idx_c = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]+" ");
				if (map[i][j] == M) {
					idx_r = i;
					idx_c = j;
				}
			}
			sb.append("\n");
		} // 배열 출력 완료
		System.out.print(sb);
		System.out.println((idx_r + 1) + " " + (idx_c + 1));

	}// main end
}
