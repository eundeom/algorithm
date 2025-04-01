import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int computer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine()); // computer
        int n = Integer.parseInt(br.readLine()); // line

        graph = new ArrayList[c+1];
        visited = new boolean[c+1];


        for (int i = 1; i <= c; i++) {
            graph[i] = new ArrayList<>();
        }

        // input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향
            graph[x].add(y);
            graph[y].add(x);
        }

//        System.out.println(Arrays.toString(graph));

        dfs(1);

        System.out.println(computer-1);

    }

    static void dfs(int a){
        visited[a] = true; // 방문 처리
        computer++;

        for(int next: graph[a]){ // 하나씩 전부 방문
            if(!visited[next]){
                dfs(next);
            }
        }
    }

}
