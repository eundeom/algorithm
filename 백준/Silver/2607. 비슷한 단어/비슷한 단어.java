import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] w1 = br.readLine().toCharArray();

        int cnt = 0;

        for(int i=0; i<N-1; i++){
            char[] clone = w1.clone();
            char[] w2 = br.readLine().toCharArray();

            if(comparison(clone, w2, N)){ // 만약 true면 같은 구성을 갖는거임
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    public static boolean comparison(char[] w1, char[] w2, int N){
        // w1 != w2 다르면 w2가 w1보다 긴지, 짧은지, 같은지 확인
        int wl1 = w1.length, wl2 = w2.length;

        int same = 0;
        
        for(int i=0; i<wl1; i++){
            for(int j=0; j<wl2; j++){
                    
                if(w1[i] == w2[j]){
                    
                    w1[i] = '-';
                    w2[j] = '*';
                    same++;
                }
            }
            
        }

        if(wl1 == wl2){ // 길이가 같으면

            if(same < wl1-1){ // 같은게 wl1 길이 - 1보다 작으면 false
                return false;
            } else{ // true
                return true;
            }
        } else if(wl1 > wl2){ // 길이가 짧으면
            int diff = wl1 - wl2;
            if(diff == 1){
                if(same == (wl1-1)){
                    return true;
                }
            } else{
                return false;
            }
        } else if(wl1 < wl2){ // 길이가 길면
            int diff = wl2 - wl1;

            if(diff == 1){
                if(same == wl1){
                    return true;
                }
            } else{
                return false;
            }
        }
        return false;
    }
    
}
