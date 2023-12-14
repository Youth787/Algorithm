import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], 1);
        }
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        System.out.println(map);
        for (int count : map.values()) {
            answer *= count;
        }
        return answer - 1;
    }
}