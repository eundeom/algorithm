import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        // 상자 쌓기
        int rows = (n + w - 1) / w;
        int[][] boxes = new int[rows][w];
        int cnt = 0, ans = 1, nx = 0, ny = 0;
        
        for (int y = 0; y < rows; y++) {
            if(y % 2 == 0){ // 짝수면 왼 -> 오
                for (int x = 0; x < w && ans <= n; x++) { // ans<=n 마지막 줄은 적을 수도 있으니까
                    boxes[y][x] = ans;
                    if(ans == num){
                        nx = x;
                        ny = y;
                    }
                    ans++;
                }
            } else{ // 홀수면 오 -> 왼
                for (int x = w - 1; x >= 0 && ans <= n; x--) {
                    boxes[y][x] = ans;
                    if(ans == num){
                        nx = x;
                        ny = y;
                    }
                    ans++;
                }
            }
        }

        System.out.println(ny + " " + nx);
        
        // 꺼내기
        // 해당 숫자에서 y++ 해서 값이 0이아닐때까지 개수 구하기
        int bcnt = 0;
        for (int y = ny; y < rows; y++) {
            if (boxes[y][nx] != 0) bcnt++;
            else break;
        }
        System.out.println(bcnt);
        

        return bcnt;
    }
}
