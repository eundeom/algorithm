import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N : 나무 수 , M : 나무 길이  ::  4 7
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 기준이 되는 수

//        System.out.println(N);
//        System.out.println(M);

        // 배열 받아오기  ::  20 15 10 17
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        // 배열 내 제일 큰 나무 길이 max에 넣기
        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        // binary search
        int left = 0;
        int right = max + 1;  // 이분 탐색에서 최대값을 포함하기 위해 max + 1로 설정

        while (left < right) {
            int mid = left + (right - left) / 2; // mid 계산 방식 변경 (오버플로우 방지!!!)
            long length = 0; 

            for (int treelength : tree) {
                // 현재 나무 길이 - 중간값이 양수일때만 더함!
                if (treelength > mid) {
                    length += (treelength - mid);
                }
            }

            // 만약에 기준값 (나무 길이)보다 크면 left를 mid + 1로 높여서 계속 binary search 진행
            if (length >= M) {
                left = mid + 1;
            } else {
                // 만약 기준값보다 작으면 right에다가 mid를 넣어서 작게 한 다음 binary search 진행
                right = mid;
            }
        }
        System.out.println(left - 1); 
    }
}
