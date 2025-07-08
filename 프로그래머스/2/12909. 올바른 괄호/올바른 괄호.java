import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        // string s의 0에서 끝까지 반복문. -> stack에 하나씩 넣음. 
        // (을 넣을때는 걍 넣음
        // )을 넣을때는 peek가 있는지 확인 - peek가 없으면 false
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            
            if(tmp == '('){
                stack.push(tmp);
            } else{
                if(!stack.isEmpty()){
                    if(stack.peek() == '('){
                        stack.pop();
                    } 
                } else{
                    return false;
                }
            }
        }
        
        if(stack.size() != 0){
            answer = false;
        } else{
            answer = true;
        }
        
        return answer;
    }
}