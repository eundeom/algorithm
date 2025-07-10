import java.util.*;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        ArrayList arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int t = sc.nextInt();
            // x 보다 작은 수 넣기
            if(t < x){
                arr.add(t);
            }
        }

        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }

    }
}
