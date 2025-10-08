import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // .startswith() 라는 함수가 있다..
        int len = phone_book.length;
        
        // 정렬하면 비슷한 접두어를 가진 전화번호끼리 붙어서 배열을 전부 다 확인할 필요 없음 😅
        Arrays.sort(phone_book);
        
        for(int i=0; i<len-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        
        return answer;
    }
}
