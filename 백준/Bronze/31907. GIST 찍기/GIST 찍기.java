import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N * 3; i++){
            for(int j = 0; j < N * 4; j++){
                if(i < N){
                    if(j < N){
                        sb.append('G');
                    } else{
                        sb.append('.');
                    }
                }

                else if(i >= N * 2){
                    if(j >= N * 2 && j < N * 3){
                        sb.append('S');
                    } else{
                        sb.append('.');
                    }
                }
                
                else{
                    if(j >= N && j < N * 2){
                        sb.append('I');
                    } else if(j >= N * 3){
                        sb.append('T');
                    } else{
                        sb.append('.');
                    }
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}