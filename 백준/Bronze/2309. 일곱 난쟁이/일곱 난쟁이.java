import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main  {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] small = new int[9];
        
        for (int i = 0; i < 9; i++) {
            small[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[7];
        
        out : for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                int k = 0;
                for (int n = 0; n < 9; n++) {        
                    if (n != i && n != j) {
                        sum += small[n];
                        result[k++] = small[n];
                    }
                }
                
                if (sum == 100) {
                    Arrays.sort(result);
                    for (int m : result) {
                        System.out.println(m);
                    }
                    break out;
                }
                
            }
        }

    }
}
