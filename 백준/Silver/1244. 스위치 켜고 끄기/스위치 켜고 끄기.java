import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] array = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int n = Integer.parseInt(br.readLine());
		int[][] student = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer stu = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				student[i][j] = Integer.parseInt(stu.nextToken());
			}
		} // 입력받기 완료

		for (int i = 0; i < n; i++) {
			if (student[i][0] == 1) { // 남학생인 경우
				for (int j = 0; j < T; j++) {
					if ((j + 1) % student[i][1] == 0) { // 배수이면
						array[j] = (array[j] + 1) % 2; // 스위치 전환
					}
				}
			} else { // 여학생인 경우
				int step = 1;
				int x = student[i][1] - 1;
				array[x] = (array[x] + 1) % 2;

				while (x - step >= 0 && x + step < T && array[x - step] == array[x + step]) {
					array[x - step] = (array[x - step] + 1) % 2;
					array[x + step] = (array[x + step] + 1) % 2;
					step++;
				}
			}
		}
		// System.out.print(array[0]);
		for (int i = 0; i < T; i++) {
			System.out.print(array[i]+" ");
			if ((i+1) % 20 == 0) {
				System.out.println();
			}
		}

	}// main end
}
