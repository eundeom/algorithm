class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int cnt = 1;
        int now = 0;
        int x =0, y = 0;
        
        // 0이면 숫자 넣기
        while(cnt <= n*n){
                switch(now){
                    case 0: // to the right
                        while(y<n && answer[x][y] == 0){
                            answer[x][y] = cnt++;
                            y++;
                        }
                        y--; x++;
                        now = 1;
                        break;
                    case 1: // to the down
                        while(x<n && answer[x][y] == 0){
                            answer[x][y] = cnt++;
                            x++;
                        }
                        x--; y--;
                        now = 2;
                        break;
                    case 2: // to the left
                        while(y>=0 && answer[x][y] == 0){
                            answer[x][y] = cnt++;
                            y--;
                        }
                        y++;x--;
                        now = 3;
                        break;
                    case 3: // to the up
                        while(x>=0 && answer[x][y] == 0){
                            answer[x][y] = cnt++;
                            x--;
                        }
                        x++; y++;
                        now = 0;
                        break;
                }
        }
        return answer;
    }
}