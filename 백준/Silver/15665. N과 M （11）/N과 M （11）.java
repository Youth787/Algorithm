import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, M;
	static int[] result;
	static Set<String> set;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set = new HashSet<>();
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		arr = new int[N];
		result = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		ncr(0);
		System.out.println(sb);
	}
	public static void ncr(int idx) {
		if(idx == M) {
			StringBuilder tmp = new StringBuilder();
			for(int a : result) tmp.append(a).append(" ");
			tmp.append('\n');
			String str = tmp.toString();
			
			if(!set.contains(str)) {
				set.add(str);
				sb.append(tmp);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			result[idx] = arr[i];
			ncr(idx+1);
		}
	}
}
