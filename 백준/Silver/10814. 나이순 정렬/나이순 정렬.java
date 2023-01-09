import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        String[][] arr = new String[N][2];

        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
           public int compare(String[] s1, String[] s2){
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
           } 
        });

        for(int i = 0; i < N; i++){
            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        }

        System.out.println(sb);

        //s.close();
    }
}