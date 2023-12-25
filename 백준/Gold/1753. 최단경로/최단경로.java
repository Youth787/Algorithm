import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class node{
    int index;
    int weight;
    public node(int index, int weight){
        this.index = index;
        this.weight = weight;
    }
}

public class Main {
    static List<node>[] adj;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V+1];
        dist = new int[V+1];
        visit = new boolean[V+1];

        for(int i=1; i<=V; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            adj[start].add(new node(end, W));
        }

        dijkstra(K);

        for(int i =1; i<=V; i++) System.out.println(dist[i]==Integer.MAX_VALUE? "INF":dist[i]);

    }
    public static void dijkstra(int start){
        PriorityQueue<node> q = new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);
        q.add(new node(start, 0));
        dist[start] = 0;


        while(!q.isEmpty()){
            node curr = q.poll();
            
            if(!visit[curr.index]) visit[curr.index]= true;

            for(node next : adj[curr.index]){
                if(!visit[next.index] && dist[next.index]> curr.weight + next.weight){
                    dist[next.index] = curr.weight + next.weight;
                    q.add(new node(next.index, dist[next.index]));
                }
            }

        }
    }
}
