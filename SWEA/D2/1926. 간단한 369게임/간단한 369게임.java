import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			String s = String.valueOf(i);
			if (s.contains("3") || s.contains("6") || s.contains("9"))
				System.out.print((s.replaceAll("[369]", "-")).replaceAll("[1245780]", "") + " ");
			else
				System.out.print(s + " ");
		}
	}// main end
}
