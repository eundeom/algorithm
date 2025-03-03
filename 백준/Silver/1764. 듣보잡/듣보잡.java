import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // output 저장용
        ArrayList<String> save = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 번에 불러와서 나누기용

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> names = new HashSet<String>();
        HashSet<String> names2 = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            names2.add(br.readLine());
        }

        int count = 0;
        for (String next : names) { // HashSet names와 names 비교
            if (names2.contains(next)) {
                save.add(next);
                count++;
            }
        }

        save.sort(String::compareTo);

        System.out.println(count);
        for (String output : save) {
            System.out.println(output);
        }
    }
}
