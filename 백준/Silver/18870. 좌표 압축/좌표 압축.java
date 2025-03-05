import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        String[] numbers = input.split(" ");

        HashSet<Integer> arr = new HashSet<Integer>();
        for(String num : numbers) {
            arr.add(Integer.parseInt(num));
        }

        // 중복 제거 - set으로 완료
        // 정렬 - ArrayList로 변경
        ArrayList<Integer> a = new ArrayList<Integer>(arr);
        Collections.sort(a); // 정렬!

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int num : a) {
            map.put(num, index++);
        }

        for(String num : numbers){
            sb.append(map.get(Integer.parseInt(num))).append(" ");
        }
        System.out.println(sb.toString());
    }
}
