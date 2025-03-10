import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int m, n, k;
    static int[][] cabbage;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            k = Integer.parseInt(st.nextToken()); // 배추 개수

            // 2차원 배열 초기화
            cabbage = new int[n][m];
            visited = new boolean[n][m];

            // 배추 위치 입력 (k번 반복해야 함)
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[y][x] = 1; // (x, y) 좌표에 배추 심기
            }

            int lump = 0; // 배추 덩어리 개수

            // 전체 배열을 돌면서 배추 덩어리 개수 구하기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 배추가 있고 방문하지 않았다면 DFS 실행
                    if (cabbage[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        lump++;
                    }
                }
            }

            System.out.println(lump);
        }

        br.close();
    }

    public static void dfs(int ci, int cj) {
        visited[ci][cj] = true;

        for (int i = 0; i < 4; i++) {
            int ni = ci + dx[i];
            int nj = cj + dy[i];

            if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                if (cabbage[ni][nj] == 1 && !visited[ni][nj]) {
                    dfs(ni, nj);
                }
            }
        }
    }
}
