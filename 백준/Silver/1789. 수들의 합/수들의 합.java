import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long sum = 0;
        long i = 0;
        while (!(sum > N)) {
            i++;
            sum += i;
        }

        long ans = i - 1;

        System.out.println(ans);
    }
}
