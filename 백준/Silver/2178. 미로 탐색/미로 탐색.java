import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Edge {
		int x;
		int y;

		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] miro, distance;
	static int N, M;
	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Edge> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new int[N][M];
		distance = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(input[j]);
				distance[i][j] = -1;
			}
		} // 입력 받기 끝

		distance[0][0] = 0;
		BFS(0, 0);
		
		System.out.println(distance[N-1][M-1]+1);
	}// main end

	public static void BFS(int i, int j) {
		queue.add(new Edge(i, j));

		while (!queue.isEmpty()) {
			Edge curr = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int X = curr.x + dir[d][0];
				int Y = curr.y + dir[d][1];

				if (X < 0 || X >= N || Y < 0 || Y >= M) 
					continue;
				
				if(miro[X][Y]==0||distance[X][Y]!=-1) 
					continue;
				
				queue.add(new Edge(X,Y));
				distance[X][Y] = distance[curr.x][curr.y]+1;
			}
		}
	} // bfs end
}
