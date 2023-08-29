import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long M = Integer.parseInt(st.nextToken());
			
			boolean flag = true;
			for(int i=0;i<N;i++) {
				if(!((M & (1 << i)) > 0)) {
					flag = false;
				}
			}
			
			System.out.print("#" + tc + " ");
			System.out.println(flag == true ? "ON" : "OFF");
		} // tc end
	}// main end
}
