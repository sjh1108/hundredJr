import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        boolean[] S = new boolean[21];
        while(N-- > 0){
            String s = br.readLine();

            if(s.equals("all")){
                for(int i = 1; i < 21; i++){
                    S[i] = true;
                }
                continue;
            }

            else if(s.equals("empty")){
                S = new boolean[21];
                continue;
            }

            st = new StringTokenizer(s);

            String str = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if(str.equals("add")){
                if(S[x] == false){
                    S[x] = true;
                }
            }

            else if(str.equals("remove")){
                if(S[x] == true){
                    S[x] = false;
                }
            }

            else if(str.equals("check")){
                if(S[x] == true){
                    sb.append(1);
                }

                else{
                    sb.append(0);
                }

                sb.append('\n');
            }

            else if(str.equals("toggle")){
                if(S[x] == true){
                    S[x] = false;
                }
                else{
                    S[x] = true;
                }
            }
        }

        System.out.println(sb);
    }
}