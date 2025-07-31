import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N: 영어 지문에 나오는 단어의 개수
        // M: 외울 단어의 길이

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken(); // String -> Int (Integer.parseInt(-))
        String M = st.nextToken();

        // ArrayList<String> arr = new ArrayList<>();
        HashMap<String, Integer> arr = new HashMap<String, Integer>();
        for(int i=0; i<Integer.parseInt(N); i++){
            String tmp = br.readLine();
            if(tmp.length() >= Integer.parseInt(M)){ // 길이 넘는지 확인
                if(arr.containsKey(tmp)){ // 해시맵에 들어가느냥
                    arr.put(tmp, arr.get(tmp) + 1);
                } else{
                    arr.put(tmp, 1);
                }
            }
        }

        List<String> words = new ArrayList<>(arr.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                // 1. 자주 나오는 단어 순으로 정렬하기 (Value로 정렬) -- 내림차순
                if(Integer.compare(arr.get(o1), arr.get(o2)) != 0){
                    return Integer.compare(arr.get(o2), arr.get(o1));
                }

                // 2. 단어 빈도 같으면 길이가 길수록 앞으로 배치
                if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }

                // 3. 빈도, 길이 같으면 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str : words){
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}
