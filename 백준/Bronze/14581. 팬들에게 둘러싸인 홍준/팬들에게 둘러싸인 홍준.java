import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        sb.append(":fan::fan::fan:\n");
        sb.append(":fan::").append(s).append("::fan:\n");
        sb.append(":fan::fan::fan:\n");

        System.out.println(sb);
    }
}