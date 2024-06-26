import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
           list.add(numbers[i]);
        }
        
        Collections.sort(list, (a,b)->{
            String aa = String.valueOf(a);
            String bb = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(aa+bb),Integer.parseInt(bb+aa));
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            sb.append(list.get(i));
        }
        
        String answer = sb.toString();
        if(answer.charAt(0) =='0') answer = "0";
        return answer;
    }
}