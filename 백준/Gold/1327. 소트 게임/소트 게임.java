import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class num {
    String str;
    int cnt;

    public num(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}

public class Main  {
    static int N, K;
    static char[] arr, copy;
    static String arr_str, copy_str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N];
        arr= br.readLine().replace(" ", "").toCharArray();

        copy = Arrays.copyOf(arr, N);
        // 배열 복사. arr배열 중 2개 불러오기
        Arrays.sort(arr);
        arr_str = new String(arr);
        copy_str = new String(copy);

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<num> q = new LinkedList<>();
        Set<String> search = new HashSet<>();
        q.offer(new num(copy_str,0));

        while (!q.isEmpty()) {
            num curr = q.poll();
            String str = curr.str;
            int cnt = curr.cnt;

            if(arr_str.equals(str)) return cnt;

            if(!search.contains(str)){
                search.add(str);
                for(int i=0; i<=N-K;i++){
                    q.offer(new num(reverseStr(str,i,i+K), cnt+1));
                }
            }
        }
        return -1;
    }

    public static String reverseStr(String str, int i, int j){
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0,i));
        // 0부터 i-1값까지 자르기

        String reverse = str.substring(i,j);
        for(int t= K-1; t>=0; t--){
            sb.append(reverse.charAt(t));
        }

        sb.append(str.substring(j,N));
        return sb.toString();
    }
}
