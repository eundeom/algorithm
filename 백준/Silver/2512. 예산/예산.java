import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        // inputs - N(지방의 수), 지방, budget
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int budget = Integer.parseInt(br.readLine());

        int sum = Arrays.stream(arr).sum();
        if(sum <= budget){
            System.out.println(arr[N-1]);
            return;
        }

        // 최소요청, 최대요청, 상한액, 합계
        int min = arr[0], max = arr[N-1], sumMax = 0, result = 0;
        
        

        // min - max 사이의 수 전부 반복하기
        for(int i=1; i<=max; i++){
            // 현재 상한액으로 계산된 금액 반환
            int a = findClosestUnderBudget(i, arr, budget);
            if(a == 0) {
                // result = i-1;
                System.out.println(i-1);
                // break;
                return;
            }
            sumMax = Math.max(max, a);
        }

        System.out.println(result);

    }

    // 현재 상한액으로 전체 요청된 금액 계산하는 함수 (총 예산 넘으면 0 반환)
    public static int findClosestUnderBudget(int priceCap, int[] arr, int budget){
        int total = 0;

        for(int i=0; i<arr.length; i++){
            // 만약 요청 금액이 상한액보다 크면 total += 상한액 | 작으면 total += 요청금액
            if(arr[i] > priceCap){
                total += priceCap;
            } else{
                total += arr[i];
            }
        }

        if(total > budget){
            return 0;
        }
        
        return total;
    }
    
}