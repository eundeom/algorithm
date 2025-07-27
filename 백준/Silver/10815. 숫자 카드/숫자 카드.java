import java.util.*;
import java.io.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 카드 개수 N
        ArrayList<Integer> arr = new ArrayList<>();
        String[] input = br.readLine().split(" "); // 상근이가 가지고 있는 카드의 숫자
        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(input[i]));
        }
        Collections.sort(arr);

        int M = Integer.parseInt(br.readLine()); // 상근이가 가진 카드인지 아닌지를 구분해야할 카드 M개
        ArrayList<Integer> result = new ArrayList<>(); // 결과 저장할 배열
        String[] comp = br.readLine().split(" "); // 비교해야할 카드들 입력받기
        for(int i=0; i<M; i++){
            int cmp = Integer.parseInt(comp[i]);
            if(isInThere(cmp, arr)){
                // 만약에 있으면 true이면 result에 add 1
                result.add(1);
            } else{
                result.add(0);
            }
        }
        for(int r : result){
            System.out.print(r + " ");
        }

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
