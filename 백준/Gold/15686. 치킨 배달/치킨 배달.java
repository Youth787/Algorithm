import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int a;
	int b;

	public Point(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}

public class Main {
	static int n, m, ans;
	static int[][] map;
	static ArrayList<Point> home = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		} // 입력받기 완료
		ans = 987654321;
		visited = new boolean[chicken.size()];
		DFS(0, 0);
		System.out.println(ans);
	}// main end

	public static int dist(int ha, int hb, int ca, int cb) {
		return Math.abs(ha - ca) + Math.abs(hb - cb);
	}

	public static void DFS(int sidx, int idx) {
		if (sidx == m) {
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = 987654321;
				for (int j = 0; j < chicken.size(); j++) {
					if (visited[j]) {
						int dist = dist(home.get(i).a, home.get(i).b, chicken.get(j).a, chicken.get(j).b);
						min = Math.min(dist, min);
					}
				}
				sum += min;
			}
			ans = Math.min(sum, ans);
			return;
		}

		for(int i=idx; i<chicken.size(); i++) {
			visited[i] = true;
			DFS(sidx+1,i+1);
			visited[i]=false;
		}
	}// dfs end
}
