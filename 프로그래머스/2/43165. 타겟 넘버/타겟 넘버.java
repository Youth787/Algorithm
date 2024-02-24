class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0,0);  
    }
    
    private static int DFS(int[] numbers,int target, int sum, int idx){
        answer =0;
        
        if(idx == numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        
        answer += DFS(numbers, target, sum+numbers[idx],idx+1);
        answer += DFS(numbers, target, sum-numbers[idx],idx+1);
        
        return answer;
    }
}