class Solution {
    public int solution(String message) {
        // 글자를 가로 2cm 크기로 적기 + 편지를 가로로 적기 + 축하 문구 message를 적기 위한 편지지 최소 가로 길이 
        
        int cnt = 0;
        for(char m : message.toCharArray()){
            cnt++;
        }
        
        
        return cnt * 2;
    }
}