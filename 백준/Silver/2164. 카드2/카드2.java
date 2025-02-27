import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            queue.add(i+1);
        }

        while(queue.size() != 1){
            queue.remove();
            int a = queue.remove();
            queue.add(a);
        }
        System.out.println(queue.remove());
    }
}
