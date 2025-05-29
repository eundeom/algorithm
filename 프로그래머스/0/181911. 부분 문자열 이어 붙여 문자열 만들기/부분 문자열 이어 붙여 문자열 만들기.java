import java.util.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String result = "";
        
//         my_strings 배열 길이만큼 for문 돌리고 parts[i][0], parts[1]로 배열 잘라서 result에 넣기
        
        for(int i=0; i<my_strings.length; i++){
            result += my_strings[i].substring(parts[i][0],parts[i][1]+1);
        }
        return result;
    }
}