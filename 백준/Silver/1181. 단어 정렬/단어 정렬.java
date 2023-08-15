import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 단어 개수

        HashSet<String> wordSet = new HashSet<>(); // 중복 제거를 위해 HashSet 사용

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            wordSet.add(s);
        }

        List<String> wordList = new ArrayList<>(wordSet); // 중복 제거된 단어를 리스트로 변환
        // Collections.sort(wordList); // 단어를 사전순으로 정렬

        String[] wordarray = wordList.toArray(new String[wordList.size()]);
        
		Arrays.sort(wordarray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 다중 조건
				if (o1.length() == o2.length()) { // 첫번째 열의 원소가 같을 경우
					return o1.compareTo(o2); // 두번째 열의 원소를 오름차순 정렬
				} else {
					return o1.length() - o2.length(); // 그렇지 않다면 첫번째 열의 원소를 오름차순 정렬
				}
			}
		});
		
		// 단어 사전순 정렬은 대부분 알고있겠지만 compareTo() 메소드를 쓰면 된다.

		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<wordarray.length; i++) {
			sb.append(wordarray[i]+"\n");
		}System.out.println(sb);
		
		
//        for (String s : wordarray) {
//            System.out.println(s);
//        }

	}
}
