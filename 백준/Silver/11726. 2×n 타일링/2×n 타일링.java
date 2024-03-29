import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr = new int[1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr[1] = 1;
		arr[2] = 2;
		System.out.println(pivo(N));
	}// main end
	
	public static int pivo(int n) { 
		if(arr[n]>0) return arr[n];
		return arr[n] = (pivo(n - 1)+ pivo(n - 2)) % 10007;

	}
}
