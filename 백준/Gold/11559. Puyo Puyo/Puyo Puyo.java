import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static Character[][] map;
    static boolean[][] visit;
    static int color_cnt;
    static int ans =0;
    static char color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new Character[12][6];
        for(int i=0; i<12; i++){
            String s = br.readLine();
            for(int j=0; j<6; j++) map[i][j] = s.charAt(j);
        }

        Character[][] clone = new Character[12][6];
        boolean flag = true;
        out : while(flag) {
            for (int i = 0; i < 12; i++)
                clone[i] = Arrays.copyOf(map[i], 6);
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    visit = new boolean[12][6];
                    color = map[i][j];
                    if (color != '.' && !visit[i][j]) {
                        color_cnt = 0;
                        DFS(i, j);
                        if (color_cnt >= 4) {
                            // true 부분 . 으로 만들고
                            for (int m = 11; m >= 0; m--) {
                                for (int n = 0; n < 6; n++) {
                                    if (visit[m][n]) {
                                        map[m][n] = '.';
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 뿌요 밑으로 내리기
            for(int i=11; i>=0; i--){
                for(int j=0; j<6;j++){
                    if(map[i][j].equals('.')){
                        int point = 11;
                        for(int p=11; p>=0; p--){
                            char mark = map[p][j];
                            if(mark!='.'){
                                map[p][j] = '.';
                                map[point][j] = mark;
                                point --;
                            }
                        }
                    }
                }
            }

            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (!map[i][j].equals(clone[i][j])) {
                        ans++; // 연쇄 +1
                        continue out;
                    }
                }
            }
            flag = false;
        }

        System.out.println(ans);
    }// main end
    public static void DFS(int i, int j){
        if(!map[i][j].equals(color)) return;
        visit[i][j] = true;
        color_cnt ++;

        for(int k=0; k<4; k++){
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            if(r>=0 && r<12 && c>=0&& c<6 && !visit[r][c]){
                DFS(r,c);
            }
        }
    }
}
