import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static LinkedList<String> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			list = new LinkedList<>();
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				String command = st.nextToken();
				if (command.equals("I")) 
					insert();
				else if (command.equals("D")) 
					delete();
				else if (command.equals("A")) 
					add();
			}

			System.out.print("#" + tc); // 결과 출력
			for (int i = 0; i < 10; i++)
				System.out.print(" " + list.get(i));
			System.out.println();
		} // test case end
	}// main end

	static int first, count;
	public static void insert() {
		first = Integer.parseInt(st.nextToken()); 
		count = Integer.parseInt(st.nextToken());
		for (int j = 0; j < count; j++)
			list.add(j + first, st.nextToken()); 
	}

	public static void delete() {
		first = Integer.parseInt(st.nextToken());
		count = Integer.parseInt(st.nextToken());
		for (int j = 0; j < count; j++)
			list.remove(first);
	}

	public static void add() {
		count = Integer.parseInt(st.nextToken());
		for (int j = 0; j < count; j++)
			list.add(st.nextToken());
	}
}
