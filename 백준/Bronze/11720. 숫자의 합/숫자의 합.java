import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String strArr = sc.next();
		
		char[] chararray = strArr.toCharArray();
		// toCharArray() 
		// 문자열 한 글자씩 쪼개서 이를 char 배열에 집어넣어주는 메소드 
		
		// String s = new String(chararray); 하면 다시 배열을 합쳐서 하나의 문자열을 만들어준다. 
		
		int sum =0;
		for(int n : chararray) {
			sum+=n-'0';
		}
		System.out.println(sum);
	}
}
