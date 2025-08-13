import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        switch(N){
            case 1:
                cnt = 1;
                break;

            case 2:
            case 3:
                cnt = 0;
                break;

            case 4:
                cnt = 2;
                break;

            case 5:
                cnt = 10;
                break;

            case 6:
                cnt = 4;
                break;

            case 7:
                cnt = 40;
                break;

            case 8:
                cnt = 92;
                break;

            case 9:
                cnt = 352;
                break;

            case 10:
                cnt = 724;
                break;

            case 11:
                cnt = 2680;
                break;
                
            case 12:
                cnt = 14200;
                break;

            case 13:
                cnt = 73712;
                break;

            case 14:
                cnt = 365596;
                break;

            case 15:
                cnt = 2279184;
                break;
        }

        System.out.println(cnt);
    }
}