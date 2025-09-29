import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numlist, int n) {
        int[] answer = {};
        // n 기준으로 n과 가까운 수부터 정렬 
        // n으로부터 거리가 같으면 더 큰 수를 앞에 오도록 배치.
        // [1,2,3,4,5,6] -> [4,5,3,6,2,1]
        // n, n-1, n+1, n-2, n+2, ...
        
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<numlist.length; i++){
            int abs = Math.abs(numlist[i]-n); //절댓값
            
            if(!map.containsKey(abs)){ // 키가 없으면 새로 추가
                map.put(abs, new ArrayList<>());
                map.get(abs).add(numlist[i]);
            } else{ // 키가 이미 있으면 value에 추가
                map.get(abs).add(numlist[i]);
            }
        }
        
        
        System.out.println(map.keySet());
        System.out.println(map.values());
        
        // key 정렬
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        // 정렬한 key 순서대로!!
        for(Integer k : keys){
            // 순서대로 res에 insert
            List<Integer> values = map.get(k); // key에 있는 value 다 담음
            // 근데 큰 수부터 담아야됨
            Collections.sort(values, Collections.reverseOrder());
            
            for(Integer v : values){
                res.add(v);
            }
            
        }
        
        // for(int r : res){
        //     System.out.println(r);
        // }
        return res;
    }
}