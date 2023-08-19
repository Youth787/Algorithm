import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main  {
    // 백준 2547. 사탕 선생 고창영
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // case 

        for(int i=0; i<T; i++){
            br.readLine(); // 공백 글자를 받는다. 
            int n = Integer.parseInt(br.readLine()); // 사탕을 가져온 아이들 수 

            BigInteger sum = new BigInteger("0"); // sum 을 0으로 초기화. BigInteger를 사용하기 때문에 0을 String으로 받는다 
            
            for(int j=0; j<n; j++){
                sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }
            System.out.println((String.valueOf(sum.remainder(BigInteger.valueOf(n))).equals("0"))? "YES":"NO");
        }
    }
}
