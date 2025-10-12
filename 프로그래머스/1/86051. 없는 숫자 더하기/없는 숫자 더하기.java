class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        // 0~9까지 숫자 중 일부가 들어있는 정수 배열 Numbers
        // numbers에서 찾을 수 없는 0~9까지 숫자를 모두 찾아 더한 수를 return하도록 
        int len = numbers.length;
        int[] nums = new int[10];
        
        for(int n : numbers){
            nums[n] = 1;
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 1){
                answer += i;
            }
        }
        return answer;
    }
}