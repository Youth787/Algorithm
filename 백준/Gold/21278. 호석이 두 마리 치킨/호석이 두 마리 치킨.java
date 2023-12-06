import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		int[][] adj = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			adj[a][b] = adj[b][a] = 1;
		}

		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				if (adj[i][j] == 1) dist[i][j] = adj[i][j];
				else dist[i][j] = 10000;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int first = Integer.MAX_VALUE;
		int last = Integer.MAX_VALUE;
		int sum = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int tmp = simulate(i, j);
				if (sum > tmp) {
					first = i;
					last = j;
					sum = tmp;
				}
			}
		}

		System.out.println(first + " " + last + " " + sum*2);
	}

	public static int simulate(int i, int j) {
		int distance = 0;
		for (int k = 1; k <= N; k++)
			distance += Math.min(dist[i][k], dist[j][k]);
		return distance;
	}
}
