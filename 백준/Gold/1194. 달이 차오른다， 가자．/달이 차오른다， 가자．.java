import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location{
    int x;
    int y;
    int cnt;
    int keys;
    public location(int x, int y, int cnt, int keys){
        this.x = x;
        this.y= y;
        this.cnt = cnt;
        this.keys = keys;
    }
}

public class Main {
    static int N,M;
    static char[][] arr;
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }// 입력완료

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '0') {
                    BFS(i, j);
                    break;
                }
            }
        }

        System.out.println(answer);
    }
    public static void BFS(int i , int j){
        Queue<location> q = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][64];
        q.add(new location(i,j,0,0));
        visit[i][j][0] = true;

        while(!q.isEmpty()){
            location current = q.poll();
            int x = current.x;
            int y= current.y;
            int cnt = current.cnt;
            int keys = current.keys;

            for(int k =0; k<4; k++){
                int r = x+dir[k][0];
                int c = y+dir[k][1];

                if(r>=0 && c>=0 && r<N && c<M && !visit[r][c][keys]){ // 범위안에 있고 방문한 적이 없으면
                    char cell = arr[r][c];
                    if(cell=='#') continue;
                    else if(cell=='.'||cell=='0'){
                        visit[r][c][keys] = true;
                        q.add(new location(r,c,cnt+1,keys));
                    }else if(cell>='a' && cell<='f'){
                        int newkeys = keys | (1<<(cell-'a'));
                        if(!visit[r][c][newkeys]) {
                            visit[r][c][newkeys] = true;
                            q.add(new location(r, c, cnt + 1, newkeys));
                        }
                    }else if(cell>='A' && cell <= 'F'){
                        if((keys & (1<< (cell-'A')))!=0){
                            visit[r][c][keys] = true;
                            q.add(new location(r,c,cnt+1,keys));
                        }
                    }else if(cell == '1'){
                        answer = cnt+1;
                        return;
                    }
                }
            }
        }
        answer = -1;
    }
}
