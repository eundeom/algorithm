import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        HashSet<Integer> arr = new HashSet<Integer>();
        HashSet<Integer> arr2 = new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>();

        String input = br.readLine();
        String[] numbers = input.split(" ");

        for(String num : numbers) {
            arr.add(Integer.parseInt(num));
        }

        String input2 = br.readLine();
        String[] numbers2 = input2.split(" ");

        for(String num : numbers2) {
            arr2.add(Integer.parseInt(num));
        }

        // 차집합
        for(Integer next : arr){
            if(!arr2.contains(next)){
                res.add(next);
            }
        }

        for(Integer next : arr2){
            if(!arr.contains(next)){
                res.add(next);
            }
        }

        System.out.println(res.size());

    }
}
