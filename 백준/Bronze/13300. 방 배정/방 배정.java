
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] student = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer student_st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(student_st.nextToken());
			student[i][1] = Integer.parseInt(student_st.nextToken());
		} // 입력받기 완료

		int max = 0;
		for (int i = 0; i < N; i++) {
			if (student[i][1] > max) {
				max = student[i][1];
			}
		} // 몇학년까지 있는지 확인한다.

		// 학년의 수 +1 만큼 크기의 2차원 배열을 생성한다.
		int[][] result = new int[max+1][2];

		for (int i = 0; i < N; i++) {
			if(student[i][0]==1) {
				result[student[i][1]][0]++;
			}else {
				result[student[i][1]][1]++;
			}
		} // 여자 남자, 학년에 맞춰 수를 센다. 

		int count =0;
		for(int i=1; i<=max; i++) {
			count += result[i][0] / K ;
			if(result[i][0] % K !=0) {
				count+=1;
			}
			count += result[i][1] / K;
			if(result[i][1] % K !=0) {
				count+=1;
			}
		}
		
		System.out.println(count);
	}// main end 
}
