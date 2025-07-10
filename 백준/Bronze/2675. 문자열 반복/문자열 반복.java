import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        String str = "";
        for(int i=0; i<s; i++){
            int a = sc.nextInt();
            str = sc.next();

            String newstr = "";
            for(int j=0; j<str.length(); j++){
                for(int k=0; k<a; k++){
                    newstr += str.charAt(j);
                }
            }
            System.out.println(newstr);
        }
        


    }
}
