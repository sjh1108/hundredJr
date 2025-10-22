import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String keyword = br.readLine();

        String key = "";
        for(int i = 0; i < origin.length(); i++){
            char c = origin.charAt(i);
            if(Character.isDigit(c)) continue;

            key += c;
        }

        System.out.println(key.contains(keyword) ? 1 : 0);
    }
}