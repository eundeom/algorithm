class Solution {
    public int[] solution(int[] numbers, String direction) {
        int leng = numbers.length;
        
        int[] answer = new int[leng];
        
        
        switch(direction){
            case "right":
                int rtmp = numbers[leng-1];
                answer[0] = rtmp;
                
                
                for(int i=1; i<leng; i++){
                    if(i-1<leng-1){
                        answer[i] = numbers[i-1];   
                    }
                }
                
                break;
                
            case "left":
                int ltmp = numbers[0];
                // 0  1   2.  3.  4.  5.  6
                // [4, 455, 6, 4, -1, 45, 6]
                for(int i=0; i<leng-1; i++){
                    if(i+1<leng){  // leng : 7, leng-1 : 6, i : 0, i+1 : 1
                        answer[i] = numbers[i+1];    
                        
                    }
                }
                answer[leng-1] = ltmp;
                
                
                // for(int a : answer){
                //     System.out.println(a);
                // }
                break;
        }
        
        
        return answer;
    }
}