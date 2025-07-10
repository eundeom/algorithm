
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // ArrayList arr = new ArrayList<>();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int z = sc.nextInt();

        int total = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == z){
                total += 1;
            }
        }

        System.out.print(total);
    }
}