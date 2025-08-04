import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int comp = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        int conn = Integer.parseInt(br.readLine()); // 직접 연결되어 있는 컴퓨터 쌍의 수

        ArrayList<Integer>[] arr = new ArrayList[comp+1]; // index 1부터 사용
        int[] visited = new int[comp+1]; // 0 으로 초기화되어있음


        // arr 어레이 리스트에 어레이 리스트를 넣어줌
        for(int i=0; i<=comp; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<conn; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        
        // 1번 컴퓨터가 웜 바이러스에 걸렸을 때 걸리는 컴퓨터 수
        System.out.println(dfs(arr, visited, 1));
    }

    public static int dfs(ArrayList<Integer>[] arr, int[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = 1; // 방문처리
        queue.add(start);
        int cnt = 0;

        // queue가 빌때까지
        while(!queue.isEmpty()){
            int curr = queue.remove();
            for(int next : arr[curr]){
                if(visited[next] == 0){
                    // 방문 안했으면 방문 처리하고 큐에 넣음
                    visited[next] = 1;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
}
