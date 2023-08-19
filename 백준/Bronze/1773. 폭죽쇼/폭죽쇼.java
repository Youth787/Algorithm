
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] student = new int[N];
		for (int n = 0; n < N; n++) {
			student[n] = Integer.parseInt(br.readLine());
		} // 입력 받기 완료

		//Set<Integer> set = new HashSet<>();

		int count =0;
		for(int c=1; c<=C; c++) {
			for(int n=0; n<N; n++) {
				int x = c%student[n];
				if(x==0) {
					count++;
					break;
				}
			}// 학생
		}// 시간초
		System.out.println(count);
	}// main end 
}
