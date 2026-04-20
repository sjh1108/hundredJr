import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append(N);
        sb.append('\n');

        int[] arr = new int[1_000_010];
        
        arr[1]=1;
        if(N%3==0){
            for(int i=1; i<=N; i+=3){
                arr[i]=-1;
                arr[i+1]=2;
                arr[i+2]=2;
            }
        }
        if(N%3==1){
            for(int i=1;i<=N;i+=3){
                arr[i]=2;
                arr[i+1]=-1;
                arr[i+2]=2;
            }
        }
        if(N%3==2){
            for(int i=2; i<=N; i+=3){
                arr[i]=2;
                arr[i+1]=-1;
                arr[i+2]=2;
            }
        }
        for(int i = 1; i < N; i++){
            arr[i] += arr[i-1];
        }

        for(int i = 0; i < N; i++){
            sb.append((arr[i]+N) % N + 1).append(' ');
        }
        sb.append(1);
        System.out.println(sb);
    }
}