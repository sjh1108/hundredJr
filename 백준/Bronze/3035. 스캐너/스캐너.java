import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++){
            String str = br.readLine();
            
            for(int zr = 0; zr < ZR; zr++){
                for(int j = 0; j < c; j++){
                    char ch = str.charAt(j);

                    for(int zc = 0; zc < ZC; zc++){
                        sb.append(ch);
                    }
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
