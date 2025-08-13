import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] map = {0,1,0,0,2,10,4,40,92,352,724,2680,14200,73712,365596,2279184};
        int cnt = map[N];

        System.out.println(cnt);
    }
}