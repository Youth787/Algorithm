import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		double[] array = new double[N];
		
		for(int i=0; i<N; i++) {
			array[i] = sc.nextDouble();
		}
		
		Arrays.sort(array); // 자바 sort 메소드 
		
		//System.out.println(Arrays.toString(array));
			
		double sum =0;
		for(int i=0; i<N; i++) {
			sum += array[i]*100/array[N-1];
		}
		
		double avg = sum/N;
		
		System.out.println(avg);

	}
}
