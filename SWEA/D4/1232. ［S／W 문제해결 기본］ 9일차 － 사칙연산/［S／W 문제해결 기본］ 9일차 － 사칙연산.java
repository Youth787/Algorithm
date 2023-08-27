
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int[][] tree;
	static String[] value;
	static StringTokenizer st;
	static Stack<Double> stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			tree = new int[N + 1][2]; // 왼자 , 오자 기록
			value = new String[N + 1]; // 노드에 저장되는 값
			stack = new Stack<Double>();
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					st.nextToken(); // 번호는 날림.
					String s = st.nextToken(); // 그다음문자 받음
					if (s.equals("/") || s.equals("+") || s.equals("-") || s.equals("*")) {
						value[i] = s;
						tree[i][0] = Integer.parseInt(st.nextToken());
						tree[i][1] = Integer.parseInt(st.nextToken());
					}
					value[i] = s;
				}
			} // 입력받기 완료
			
			postorder(1);
			int result = Integer.parseInt(String.valueOf(Math.round(stack.pop())));
			System.out.println("#" + tc + " "+result);
		} // tc end
	}// main end

	public static void postorder(int i) { // 후위 연산 
		if(i !=0) {
			postorder(tree[i][0]);
			postorder(tree[i][1]);
			if(value[i].equals("+")||value[i].equals("-")||value[i].equals("/")||value[i].equals("*")) { // 연산자가 나오면 
				calculate(value[i]);// 계산해라 
			}else {
				stack.push(Double.parseDouble(value[i])); // 아니면 스택에 더블값으로 넣기 
			}
		}
	}
	
	public static void calculate(String s) { // 연산자에 따라 달라지는 계산식 
		double b = stack.pop();
		double a = stack.pop();
		
		if(s.equals("+")) 
			stack.push(a+b);
		else if(s.equals("-")) 
			stack.push(a-b);
		else if(s.equals("*")) 
			stack.push(a*b);
		else if(s.equals("/")) 
			stack.push(a/b);
	}
}
