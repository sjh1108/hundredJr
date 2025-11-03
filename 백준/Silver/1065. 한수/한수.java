import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        

        if(N < 100) System.out.println(N);
        else{
            int cnt = 99;
            for(int i = 100; i <= N; i++){
                char[] num = String.valueOf(i).toCharArray();

                int preGap = 0;
                for(int j = 0; j < num.length-1; j++) {
                    if(j == 0) {
                    preGap = num[0] - num[1];
                    continue;
                    }
                
                    int curGap = num[j] - num[j+1];
                    if(preGap == curGap) {
                    cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}