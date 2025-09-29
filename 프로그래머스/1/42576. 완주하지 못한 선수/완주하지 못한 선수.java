import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> res = new HashMap<>();
        
        // key 넣고 0으로 초기화
        for(String s : participant){
            res.put(s, res.getOrDefault(s, 0) + 1);
        }
        
        // 완주했으면 감소
        for (String s : completion) {
            res.put(s, res.get(s) - 1);
        }
        
        // value 0 아닌 Key 반환
        for (String r : res.keySet()) {
            if (res.get(r) != 0) {
                answer = r;
                break;
                // System.out.println("value 0: " + r);
            }
        }
        // answer = res.containsValue(0);
        return answer;
    }
}