class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        // control = w a s d
        // w : +1, s : -1, d : +10, a : n - 10
        
        for(char c : control.toCharArray()){
            switch(c){
                case 'w':
                    n += 1;
                    break;
                case 's':
                    n -= 1;
                    break;
                case 'd':
                    n += 10;
                    break;
                case 'a':
                    n -= 10;
                    break;
            }
                    
        }
        answer = n;
        return answer;
    }
}