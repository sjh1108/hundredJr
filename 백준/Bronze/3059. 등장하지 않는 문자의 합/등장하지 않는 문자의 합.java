import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            boolean[] alpha = new boolean[26];
            char[] arr = br.readLine().toCharArray();

            for(char c : arr){
                alpha[c-'A'] = true;
            }

            int sum = 0;
            for(int i = 0; i < 26; i++){
                if(!alpha[i]){
                    sum += 'A' + i;
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }
}