import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		memo = new int[N+1];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int len=0;
		int idx =0;
		for(int i=0; i<N; i++) {
			if(memo[len]<arr[i]) {
				len+=1;
				memo[len] = arr[i];
			}else {
				idx = binarySearch(0,len,arr[i]);
				memo[idx] = arr[i];
			}
		}
		System.out.println(len);
	}
	public static int binarySearch(int left, int right, int key) {
		int mid =0;
		while(left<right) {
			mid = (left+right)/2;
			if(memo[mid]<key) left = mid+1;
			else right = mid;
		}
		return right;
	}
}
