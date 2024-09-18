import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "12 1600");
        map.put(2, "11 894");
        map.put(3, "11 1327");
        map.put(4, "10 1311");
        map.put(5, "9 1004");
        map.put(6, "9 1178");
        map.put(7, "9 1357");
        map.put(8, "8 837");
        map.put(9, "7 1055");
        map.put(10, "6 556");
        map.put(11, "6 773");

        System.out.println(map.get(N));
    }
}