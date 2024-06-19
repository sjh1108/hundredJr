import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String str = br.readLine();
        boolean flag = true;
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            char n1, n2;
            if(c == 'p'){
                if(i >= str.length()-1){
                    flag = false;
                    break;
                }
                n1 = str.charAt(i+1);
                if(n1 != 'i'){
                    flag = false;
                    break;
                } else{
                    i++;
                }
            }
            else if(c == 'k'){
                if(i >= str.length()-1){
                    flag = false;
                    break;
                }
                n1 = str.charAt(i+1);
                if(n1 != 'a'){
                    flag = false;
                    break;
                } else{
                    i++;
                }
            }
            else if(c == 'c'){
                if(i >= str.length()-2){
                    flag = false;
                    break;
                }
                n1 = str.charAt(i+1);
                n2 = str.charAt(i+2);
                if(n1 != 'h' || n2 != 'u'){
                    flag = false;
                    break;
                } else{
                    i += 2;
                }
            } else{
                flag = false;
                break;
            }
        }

        String ans = flag ? "YES" : "NO";
        System.out.println(ans);
    }
}