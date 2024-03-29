import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<>();

        int total = 0;
        String key;
        while ((key = br.readLine()) != null && !key.isEmpty()) {
            map.put(key, map.getOrDefault(key,0)+1);
            total+=1;
        }// hashmap에 각 종류별로 개수를 세서 넣기. 이때 총 개수도 세기

        // HashMap을 키를 기준으로 정렬된 TreeMap으로 변환
        TreeMap<String, Integer> sortMap = new TreeMap<>(map);

        for(Map.Entry<String,Integer> entry : sortMap.entrySet()){
            int value = entry.getValue() * 100;
            System.out.println(entry.getKey()+ " "+ String.format("%.4f",(double)value/(double) total));
        }// 출력
    }
}
