import java.util.*;

class clothes {
    String name;
    int cnt;
    
    public clothes(String name, int cnt){
        this.name = name;
        this.cnt = cnt;
    }
} 

    class Solution {
    public int solution(String[][] clothes) {
        List<clothes> list = new LinkedList<>();
        out : for(int i=0; i<clothes.length; i++){
            for(int j=0; j<list.size(); j++){
                if(list.size() !=0 && list.get(j).name.equals(clothes[i][1])) {
                    list.get(j).cnt++; continue out;}
            }
            list.add(new clothes(clothes[i][1],1));
        }
				      
        if(list.size()==1){return clothes.length;}
        else{
            int result =1;
            for(int i =0; i<list.size(); i++) result *= list.get(i).cnt;
            return clothes.length+result;
        }
    }
}