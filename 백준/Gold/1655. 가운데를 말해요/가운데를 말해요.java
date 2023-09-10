import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();

		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(maxheap.size()==0) maxheap.offer(a);
			else if(maxheap.size()!=0 && maxheap.size()==minheap.size()) maxheap.offer(a);
			else minheap.offer(a);
			
			if(minheap.size()!=0&& maxheap.peek()>minheap.peek()) {
				maxheap.offer(minheap.poll());
				minheap.offer(maxheap.poll());
			}
			
			sb.append(maxheap.peek()+"\n");
			
		}
		System.out.print(sb);
	}// main end
}
