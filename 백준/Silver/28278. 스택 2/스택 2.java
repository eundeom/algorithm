import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
- 명령 수 N 입력 받기
- 입력 받기 (한 개 인지 두 개인지 판별)
- 명령어
    - 1 * : 스택에 넣기
    - 2 : 스택에 정수 있으면, 맨 위 정수 출력하기. 없으면 -1
    - 3 : 스택에 있는 정수 개수 출력
    - 4 : 스택 비었으면 1 아니면 0
    - 5 : 스택에 정수가 있다면 맨 위 정수 출력. 없으면 -1
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 예시: 정수 하나를 입력받음
        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N+1];
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 1; i <= N; i++) {
            String input = br.readLine();

            if(input.length() > 1){ // input 값이 여러개인 경우 - 스택에 넣기!
                String[] newInput = input.split(" ");
//                int a = Integer.parseInt(newInput[0]);
                int b = Integer.parseInt(newInput[1]);

                arr.add(b);
            } else{

                // 여러개 아닌 경우 - 2, 3, 4, 5
                switch (Integer.parseInt(input)){
                    case 2: // 스택에 정수 있으면, 맨 위 정수 출력하기. 없으면 -1
                        if (!arr.isEmpty()){
                            // 마지막 값 출력 후 삭제
                            //!!!!!!! 출력 해야돼!!!!!!
                            System.out.println(arr.get(arr.size()-1)); // ArrayList : arr.get(arr.size()-1) getLast, removeLast 함수
                            arr.remove(arr.size()-1);
                        }else{
                            System.out.println(-1);
                        }
                        break;
                    case 3: // 스택에 있는 정수 개수 출력
                        System.out.println(arr.size());
                        break;
                    case 4: // 스택 비었으면 1 아니면 0
                        if(!arr.isEmpty()){
                            System.out.println(0);
                        } else {
                            System.out.println(1);
                        }
                        break;
                    case 5: // 스택에 정수가 있다면 맨 위 정수 출력. 없으면 -1
                        if(!arr.isEmpty()){
                            System.out.println(arr.get(arr.size()-1));
                        } else {
                            System.out.println(-1);
                        }

                }

            }


        }


    }
}
