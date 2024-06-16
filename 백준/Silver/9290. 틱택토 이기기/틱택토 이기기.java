import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static char[][] tic = new char[3][3];

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());

        int cnt = 0;
        outLoop: while(T-- > 0){
            cnt++;
            for(int i = 0; i < 3; i++){
                String s = br.readLine();
                for(int j = 0; j < 3; j++){
                    tic[i][j] = s.charAt(j);
                }
            }


            char namgyu = br.readLine().charAt(0);

            sb.append("Case ").append(cnt).append(":\n");
            for(int i = 0; i < 3; i++){ for(int j = 0; j < 3; j++){
                if(tic[i][j] == '-'){
                    tic[i][j] = namgyu;
                    
                    if(check(namgyu)){
                        for(int k = 0; k < 3; k++){
                            for(int l = 0; l < 3; l++){
                                sb.append(tic[k][l]);
                            }
                            sb.append("\n");
                        }
                        continue outLoop;
                    } else{
                        tic[i][j] = '-';
                    }
                } }
            }
        }
        System.out.println(sb);
    }

    static boolean check(char c){
        for(int i = 0; i < 3; i++){
            if(tic[i][0] == c && tic[i][1] == c && tic[i][2] == c) return true;
            if(tic[0][i] == c && tic[1][i] == c && tic[2][i] == c) return true;
        }

        if(tic[0][0] == c && tic[1][1] == c && tic[2][2] == c) return true;
        if(tic[0][2] == c && tic[1][1] == c && tic[2][0] == c) return true;

        return false;
    }
}