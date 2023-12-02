import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String first = br.readLine();
		int result =0;
		
		for (int i = 0; i < N-1; i++) {
			String input = br.readLine();
			int cnt =0;
			int[] word = new int[26];
			for(int j=0; j<first.length(); j++) {
				word[first.charAt(j)-'A']++;
			}
			
			for(int j=0; j<input.length(); j++) {
				if(word[input.charAt(j)-'A']>0) {
					cnt++;
					word[input.charAt(j)-'A']--;
				}
			}
			
			if(first.length()==input.length() && (input.length()-1==cnt || input.length()==cnt)) result++;
			else if(first.length()==input.length()-1 && input.length()-1==cnt) result++;
			else if(first.length()==input.length()+1 && input.length()==cnt) result++;
		}// for end
		
		System.out.println(result);
	}
}
