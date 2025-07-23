import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        int sum = 0;
        sum += Integer.parseInt(br.readLine());
        sum += Integer.parseInt(br.readLine());
        sum += Integer.parseInt(br.readLine());
        sum += Integer.parseInt(br.readLine());

        System.out.println(sum <= 1500 ? "Yes" : "No");
    }
}