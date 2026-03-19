import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        boolean check = true;

        st = new StringTokenizer(br.readLine());
        arr = new int[3];

        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        while(check){
            if(arr[2] >= arr[1] + arr[0]){
                sb.append("Invalid");
            }

            else if(arr[0] == arr[1] && arr[1] == arr[2]){
                sb.append("Equilateral");
            }

            else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]){
                sb.append("Isosceles");
            }

            else{
                sb.append("Scalene");
            }

            st = new StringTokenizer(br.readLine());

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0){
                check = false;
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}