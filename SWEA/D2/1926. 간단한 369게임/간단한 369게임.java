import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 0; j < String.valueOf(i).length(); j++) {
				if (String.valueOf(i).charAt(j) == '3' || String.valueOf(i).charAt(j) == '6'
						|| String.valueOf(i).charAt(j) == '9')
					count++;
			} // j for end
			if (count == 0)
				System.out.print(i + " ");
			else if (count == 1)
				System.out.print("-" + " ");
			else {
				for (int k = 0; k < count; k++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		} // i for end
	}// main end
}
