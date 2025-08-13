import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        a += Integer.parseInt(st.nextToken());
        a += Integer.parseInt(st.nextToken());
        
        if(n <= a || n <= 240){
            System.out.println("high speed rail");
        } else{
            System.out.println("flight");
        }
    }
}