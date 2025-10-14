import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        int idx = 0;
        for(int i = 2; i <= N; i++){
            int x = N;

            int sum = 0;
            while(x > 0){
                sum += x % i;
                x /= i;
            }

            if(sum > max){
                max = sum;
                idx = i;
            }
        }

        System.out.println(max + " " + idx);
    }
}