import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine()) * 100;
        int m = Integer.parseInt(br.readLine()) * 100;

        int min = Math.min(h, m);

        System.out.println(min / 2);
    }
}