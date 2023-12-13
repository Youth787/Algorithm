import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel jewel) {
        return Integer.compare(jewel.price, this.price);
    }
}

public class Main  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, price);
        }

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a, b) -> Integer.compare(a.weight, b.weight));
        Arrays.sort(bags);

        PriorityQueue<Jewel> pq = new PriorityQueue<>();

        long result = 0;
        int jewelIndex = 0;

        for (int bag : bags) {
            while (jewelIndex < n && jewels[jewelIndex].weight <= bag) {
                pq.offer(jewels[jewelIndex]);
                jewelIndex++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll().price;
            }
        }

        System.out.println(result);
    }
}
