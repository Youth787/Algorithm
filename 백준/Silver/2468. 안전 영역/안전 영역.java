import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] arr;
	static boolean[][] visit;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		int result =0;
		int max = -987654321;
		int min = 987654321;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				min = Math.min(min, a);
				max = Math.max(max, a);
			}
		} // 입력받기 완료
		
		for(int k=min-1; k<=max; k++) {
			visit = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]<=k)
						arr[i][j]=0;
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(DFS(i,j))
						cnt++;
				}
			}
			result = Math.max(result, cnt);
		}
			System.out.println(result);
		
	}
	
	public static boolean DFS(int i, int j) {
		if(visit[i][j] || arr[i][j]==0)
			return false;
			
		visit[i][j]=true;
		for(int k=0; k<4; k++) {
			int r = i+dir[k][0];
			int c = j+dir[k][1];
			if(r>=0 && r<N && c>=0 && c<N && !visit[r][c]&&arr[r][c]!=0) {
				DFS(r,c);
			}
		}
		return true;
	}
	
}
