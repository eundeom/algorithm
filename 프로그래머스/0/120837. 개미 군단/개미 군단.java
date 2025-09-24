class Solution {
    public int solution(int hp) {
        // 공격력 // 장군개미 : 5, 병정개미 : 3, 일개미 : 1
        // Ex. 체력23 - 장군개미 4, 병정개미 1
        int w = 0;
        
        if(hp>=5){
            w += (hp / 5);
            hp %= 5;
        }
        if(hp>=3){
            w += (hp / 3);
            hp %= 3;
        }
        if(hp>=1){
            w += (hp / 1);
            hp %= 1;
        }
        return w;
    }
}