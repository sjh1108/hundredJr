import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[26];
        String originString = br.readLine();
        char[] origin = originString.toCharArray();
        for(char c: origin){
            cnt[c - 'A']++;
        }
        int len = originString.length();

        int res = 0;
        int[] copy;
        for(int i = 0; i < N-1; i++){
            copy = cnt.clone();
            
            int x = 0;
            String str = br.readLine();
            char[] read = str.toCharArray();
            for(char c: read){
                if(copy[c-'A'] > 0){
                    copy[c-'A']--;
                    x++;
                }
            }
            
            boolean flag = false;

            if(len == str.length() && (x == len || x == len-1)){
                flag = true;
            } else if(len == str.length()+1 && x == str.length()){
                flag = true;
            } else if(len == str.length()-1 && x == str.length()-1){
                flag = true;
            }

            if(flag) res++;
        }
        System.out.println(res);
    }
}