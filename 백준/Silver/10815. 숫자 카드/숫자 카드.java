import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 카드 개수 N
        int[] arr = new int[N];
        String[] input = br.readLine().split(" "); // 상근이가 가지고 있는 카드의 숫자
        for(int i=0; i<N; i++){
            arr[i] = (Integer.parseInt(input[i]));
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine()); // 상근이가 가진 카드인지 아닌지를 구분해야할 카드 M개
        StringBuilder result = new StringBuilder(); // 결과 저장할 배열
        String[] comp = br.readLine().split(" "); // 비교해야할 카드들 입력받기
        for(int i=0; i<M; i++){
            int cmp = Integer.parseInt(comp[i]);
            if(Arrays.binarySearch(arr, cmp) >= 0){
                // java 내부적으로 최적화된 이진탐색 메서드 :: 해당 arr에서 key가 존재하면 index, 없으면 음수 반환
                result.append("1 ");
            } else{
                result.append("0 ");
            }
        }
        System.out.print(result);
    }

    // 상근이가 가진 수인지 확인할 숫자 cmp, 상근이가 가진 수의 배열 arr, mid
    public static boolean isInThere(int cmp, ArrayList<Integer> arr){
        int left = 0, right = arr.size()-1, mid = (left + right)/2;

        while(left <= right){
            if(cmp == arr.get(mid)){
                return true;
            } else if(cmp < arr.get(mid)){
                right = mid - 1;
                mid = (left + right)/2;
            } else if(cmp > arr.get(mid)){
                left = mid + 1;
                mid = (left + right)/2;
            }
        }

        return false;
    }
}
