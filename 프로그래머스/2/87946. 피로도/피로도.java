import java.util.*;

class Solution {
    int ans =0;
    int[][] arr;
    int N;
    int K;
    int[] result;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        arr= dungeons;
        N = dungeons.length;
        K = k;
        result = new int[N];
        visit = new boolean[N];
        npn(0);
        return ans;
    }
    public void npn(int idx){
        if(idx==N){
            int P = K;
            int cnt =0;
            for(int a : result){
                if(P>=arr[a][0]){
                    P -= arr[a][1];
                    cnt++;
                } else break;
            }            
            ans = Math.max(ans,cnt);
            return;
        }
        
        for(int i=0; i<N; i++){
            if(visit[i]) continue;
            visit[i] = true;
            result[idx] = i;
            npn(idx+1);
            visit[i] = false;
        }
    }
}