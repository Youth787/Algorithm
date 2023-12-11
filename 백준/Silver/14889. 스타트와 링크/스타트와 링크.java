import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,R;
	static int[] result;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = N/2;
		
		arr = new int[N][N];
		result = new int[R];
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ncr(0,0);
		System.out.print(min);
	}
	public static void ncr(int idx, int sidx) {
		if(sidx == R) {
			int start =0;
			int link =0;
			int res =0;
			boolean[] team = new boolean[N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<R; j++) {
				if(i == result[j]) team[i] = true;
				}
			}
			
			for(int i=0; i<arr.length-1; i++) {
				for(int j=i; j<arr.length; j++) {
					if(team[i] && team[j]) start += arr[i][j] + arr[j][i];
					else if(!team[i] && !team[j]) link += arr[i][j] + arr[j][i];
				}
			}
			
			res = Math.abs(start-link);
			min = Math.min(res, min);
			return;
		}
		
		if(idx ==N) return;
		
		result[sidx] = idx;
		ncr(idx+1,sidx+1);
		ncr(idx+1,sidx);
	}
}
