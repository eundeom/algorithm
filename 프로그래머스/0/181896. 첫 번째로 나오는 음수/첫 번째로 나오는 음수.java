class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        // 첫번쨰로 나오는 음수의 인덱스를 return
        for(int i=0; i<num_list.length; i++){
            if(num_list[i] < 0){
                answer = i;
                break;
            }
            if(i==num_list.length-1) answer = -1;
        }
        return answer;
    }
}