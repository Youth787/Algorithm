import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int count = 0;
			String n = br.readLine();
			char c = '1';
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) == c) {
					count++;
					c = (char) (((Character.getNumericValue(c) + 1) % 2) + '0');
				}
			}
			System.out.println("#" + tc + " " + count);
		} // tc end
	}// main end
}
