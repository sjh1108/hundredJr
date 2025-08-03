import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 10001;
        
        if(str.indexOf('x') == -1){
            System.out.println(0);
            return;
        }

        if (str.charAt(0) == 'x') {
            answer = 1;
        } else if (str.charAt(0) == '-' && str.charAt(1)=='x') {
            answer = -1;
        }

        if (answer != 10001) {
            System.out.println(answer);
            return;
        }

        int idx = str.indexOf('x');
        String ans = "";
        for (int i = idx - 1; i >= 0; i--) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                ans = str.charAt(i) + ans;
                break;
            }
            ans = str.charAt(i) + ans;
        }
        System.out.println(ans);
    }
}