import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String[][] person = new String[T][2];
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i][0] = st.nextToken();
			person[i][1] = st.nextToken();
		}
		
		Arrays.sort(person, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1 ,String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String[] a : person) {
			System.out.println(Integer.parseInt(a[0])+" "+a[1]);
		}
	}
}
