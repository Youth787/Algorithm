import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Edge{
		int st,dep;
		public Edge(int st, int dep) {
			this.st = st;
			this.dep = dep;
		}
	}
	
	static List<Edge>[] adjList;
	static Queue<Edge> queue;
	static boolean[] visited;
	static int[] depth;
	static int[][] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			visited =  new boolean[101]; // 방문 체크 
			depth = new int[101]; // 깊이 값 갱신 
			queue = new LinkedList<>(); // bfs를 위한 큐 
			adj = new int[101][101]; // 인접행렬 
			
			// 입력 받기 
  			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<N/2; i++) adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			
			BFS(S);
			
			int max = 0;
			int ans =0;
			for(int i=1; i<101; i++) {
				if(depth[i]>=max) {
					max = depth[i];
					ans = i;
				}
			} // 깊이가 가장 깊은 것 중 가장 큰 
			
			System.out.println("#"+tc+" "+ans);
		}// test case end 
	}// main end 
	
	public static void BFS(int s) {
		queue.add(new Edge(s,1)); // 큐에 추가 
		visited[s] = true; // 방문 체크 
		depth[s] = 1; 
		while(!queue.isEmpty()) {
			Edge t = queue.poll();
			for(int i=0; i<101; i++) {
				if(!visited[i] && adj[t.st][i]==1) {
					depth[i] = t.dep+1; 
					visited[i] = true;
					queue.add(new Edge(i,depth[i]));
				}
			}
		}
	}
}
