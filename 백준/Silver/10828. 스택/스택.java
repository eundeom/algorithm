import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<String> st = new Stack<String>();

        for(int i=0; i<=N; i++){
            String input = sc.nextLine();
            String[] tmp = input.split(" ");
            
            switch(tmp[0]) {
                case "push":
                    st.push(tmp[1]);
                    break;
                case "pop":
                    if(st.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(st.pop());
                    }
                    break;
                case "size":
                    System.out.println(st.size());
                    break;
                case "empty":
                    if(st.isEmpty()){
                        System.out.println(1);
                    } else{
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if(st.isEmpty()){
                        System.out.println(-1);
                    } else{
                        System.out.println(st.peek());
                    }
                    break;
            }
        }
    }
    
}
