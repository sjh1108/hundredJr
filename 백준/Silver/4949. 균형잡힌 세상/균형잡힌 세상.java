import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        while(true){
            String s = br.readLine();

            if(s.equals(".")){
                break;
            }

            int tmp = 0;

            char[] crr = new char[s.length()];

            boolean check = true;

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '('){
                    crr[tmp++] = '(';
                } 

                else if(c == '['){
                    crr[tmp++] = '[';
                }

                else if(c == ')'){
                    if(tmp > 0){
                        if(crr[--tmp] == '('){
                            continue;
                        } else{
                            check = false;
                            break;
                        }
                    } else{
                        check = false;
                        break;
                    }
                } 
                
                else if(c == ']'){
                    if(tmp > 0){
                        if(crr[--tmp] == '['){
                            continue;
                        } else{
                            check = false;
                            break;
                        }
                    } else{
                        check = false;
                        break;
                    }
                } else if(c == '.'){
                    if(tmp > 0){
                        check = false;
                    }
                    break;
                }
            }

            if(check){
                sb.append("yes");
            } else{
                sb.append("no");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}