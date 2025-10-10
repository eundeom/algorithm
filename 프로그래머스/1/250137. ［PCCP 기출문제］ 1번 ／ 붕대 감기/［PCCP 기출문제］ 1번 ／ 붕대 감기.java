import java.math.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int atime = 0; // 현재 공격 인덱스
        // 현재 시간 / 연속 성공 횟수 / 최대 체력
        int now = 0, seq =0, max_health = health;
        
        while(atime < attacks.length){
            if(attacks[atime][0] == now){ // attacked
                health -= attacks[atime][1];
                if(health <= 0){
                    return -1;
                }
                seq = 0;
                atime++;
            } else{ // not attacked
                seq++;
                
                health += bandage[1];
                health = Math.min(health, max_health); // 초과 방지

                
                if(seq == bandage[0]){ // check sequence
                    seq = 0;
                    health += bandage[2];
                    health = Math.min(health, max_health);
                }
            }
            now++;
        }
        

        
        return health;
    }
}