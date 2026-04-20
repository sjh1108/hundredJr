import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String origin = st.nextToken();
        int or = Integer.parseInt(origin);
        int ph = Integer.parseInt(st.nextToken() + origin);

        boolean flag = true;
        boolean[] visited = new boolean[ph];
        for(int i = 2; i < Math.sqrt(ph); i++){
            if(ph % i == 0 || or % i == 0) {
                flag = false;
                break;
            }

            if(visited[i]) continue;
            for(int j = 2; j * i < Math.sqrt(ph); j++){
                visited[j] = true;
            }
        }

        if(flag){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
}