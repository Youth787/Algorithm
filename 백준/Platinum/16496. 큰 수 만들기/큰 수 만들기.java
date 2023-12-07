import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] input = new String[N];
		
 		for(int i=0; i<N; i++) {
 			input[i] = st.nextToken();
 		}// 입력받기 완료 
 		
 		Arrays.sort(input, ((x,y)->(y+x).compareTo(x+y))); // 역순 비교를 통해 내림차순 정렬 되도록 하였다. 

 		StringBuilder sb = new StringBuilder();
 		for(String a : input) sb.append(a);
 		String result = sb.toString();
 		if(result.charAt(0)=='0') System.out.println(0);
 		else System.out.println(result);
	}
}
