import java.util.*;

class Solution {
    public long solution(long n) {
        String answer = "";
        
        ArrayList<Long> arr = new ArrayList<>();
        
        while(n/10!=0){
            arr.add(n%10);
            n /= 10;
        }
        arr.add(n);
        
        Collections.sort(arr, Collections.reverseOrder());
        
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i));
            answer += arr.get(i);
        }
        
        return Long.parseLong(answer);
    }
}