import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 입력 받은 수의 각 자리 수가 등차수열인 수의 개수 구하기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        // 1~99까지는 return N
        if(1<=N && N <=99){
            System.out.println(N);
            return;
        } else{
            cnt += 99;
            for(int i=100; i<=N; i++){
                // 각 자리 수 배열에 넣기
                ArrayList<Integer> deq = new ArrayList<>();
                int num = i;
                int index = 0;
                while(num/10!=0){
                    // 나머지 넣고 num 갱신
                    deq.add(index, num%10);
                    num = num/10; // 몫을 넣음
                    index += 1;
                }
                deq.add(index, num);

                if(checkArithmetic(deq)){ // true면 
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
    // 각 자리 수가 등차수열인지 확인하는 함수
    public static Boolean checkArithmetic(ArrayList<Integer> deq){
        // 기준 값
        int def = deq.get(0) - deq.get(1);

        for(int i=0; i<deq.size(); i++){
            if(i+1 < deq.size()){
                if(deq.get(i) - deq.get(i+1) != def){
                    return false;
                }
            }
        }

        return true;
    }
}