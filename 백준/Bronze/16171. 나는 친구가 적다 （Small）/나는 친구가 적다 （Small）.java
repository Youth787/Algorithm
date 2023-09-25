import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String str = s.replaceAll("[0-9]", ""); // 정규표현식 ^ : 제외하라는 의미
		// String str = s.replaceAll("[0-9]", ""); 0~9를 모두 공백으로 만들어라.
		// String str = s.replaceAll("[^0-9]", ""); 0~9 제외하고 나머지 모두 공백으로 만들어라.
		String v = br.readLine();

		boolean result = false;

		out: for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == v.charAt(0)) {
				int cnt = 0;
				for (int j = 0; j < v.length(); j++) {
					if (str.charAt(i + j) == v.charAt(j)) {
						cnt++;
					}else {
						continue out;
					}
				}
				if (cnt == v.length()) {
					result = true;
					break out;
				}
			}
		}

		System.out.println(result ? "1" : "0");

	}// main end
}