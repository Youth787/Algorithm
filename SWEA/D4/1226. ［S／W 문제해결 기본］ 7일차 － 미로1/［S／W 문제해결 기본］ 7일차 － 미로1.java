import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] map = new int[16][16];
	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {

			String n = br.readLine();
			for (int i = 0; i < 16; i++) {
				String s = br.readLine();
				for (int j = 0; j < 16; j++)
					map[i][j] = s.charAt(j) - '0';
			} // 입력받기 완료

			int stx = 0, sty = 0, edx = 0, edy = 0;
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if (map[i][j] == 2) {
						stx = i; sty = j;
					} else if (map[i][j] == 3) {
						map[i][j] = 0;
						edx = i; edy = j;
					}
				}
			} // 시작점과 끝점의 좌표 구하기

			DFS(stx, sty);
			System.out.println("#" + tc + " " + (map[edx][edy] == 1 ? "1" : "0"));
		} // test case end
	}// main ed

	public static void DFS(int idx, int idy) {
		map[idx][idy] = 1;
		for (int k = 0; k < 4; k++) {
			int r = idx + dir[k][0];
			int c = idy + dir[k][1];
			if (map[r][c] == 0) DFS(r, c);
		}
	}// method end
}