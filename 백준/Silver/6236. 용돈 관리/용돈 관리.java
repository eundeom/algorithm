import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 일수
        int M = sc.nextInt(); // 인출 횟수
        int max = 0;
        int sum = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            // 7일 동안 쓰는 돈
            arr.add(sc.nextInt());
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }

        int left = max, right = sum;
        int answer = sum; // 주머니

        while(left<=right){
            int mid = (left + right) / 2;

            if(canWithdraw(arr, mid, M)){
                answer = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        System.out.println(answer);

    }

    public static boolean canWithdraw(ArrayList<Integer> arr, int limit, int maxWithdraw){
        int cnt = 1; // 인출 횟수
        int sum = 0;
        
        for(int money : arr){
            if(sum + money > limit){
                cnt++;
                sum = 0;
            }
            sum += money;
        }
        return cnt <= maxWithdraw;
    }
}
