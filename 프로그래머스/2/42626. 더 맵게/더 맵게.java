import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> sheap = new PriorityQueue<Integer>();
        
        // Array to heap
        for(int s : scoville){
            sheap.add(s);
        }
        
        while(sheap.size() > 1 && sheap.peek() < K){
            int first = sheap.poll();
            int second = sheap.poll();

            sheap.offer(first + (second * 2));
            answer++;
        }
        
        if(sheap.isEmpty() || sheap.peek() < K){
            answer = -1;
        }
        
        return answer;
    }
}