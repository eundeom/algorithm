import java.util.*;

class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String st = String.valueOf(age); // int to string
        
        for(char s : st.toCharArray()){
            int digit = s - '0'; // 0 빼면 char to int '3'->3
            sb.append((char) ('a'+digit)); // 'a' = 97 + digit
        }
        
        return sb.toString(); // StringBuilder to String
    }
}