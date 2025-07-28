import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            bw.write("swimming ");
        }
        bw.write('\n');
        bw.flush();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            String str = st.nextToken();

            if(str.equals("bowling")){
                bw.write("soccer ");
            } else{
                bw.write("bowling ");
            }
        }

        bw.flush();
    }
}