import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V,E,S;
	static int[][] edge;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		edge = new int[V+1][V+1];
		visit = new boolean[V+1];
		
		for(int i =0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			edge[s][e] = edge[e][s]= 1;
		}
		
		DFS(S);
		System.out.println();
		visit = new boolean[V+1];
		BFS(S);
		System.out.println();
	}
	
	public static void DFS(int v) {
		visit[v] = true;
		System.out.print(v+" ");
		
		for(int i=1; i<=V; i++) {
			if(!visit[i] && edge[v][i]==1) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int v) {
		queue.add(v);
		visit[v] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr + " ");
			
			for(int i=1; i<=V; i++) {
				if(!visit[i] && edge[curr][i]==1) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
