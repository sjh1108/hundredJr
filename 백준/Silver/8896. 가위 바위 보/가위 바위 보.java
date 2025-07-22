import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int result = 0;

            int num = Integer.parseInt(br.readLine());

            char[][] robots = new char[num+1][];
            for(int i = 1; i <= num; i++){
                robots[i] = br.readLine().toCharArray();
            }

            int len = robots[1].length;
            boolean[] defeats = new boolean[num+1];
            
            for(int game = 0; game < len; game++){
                int d = 0;
                for(int i = 1; i <= num; i++){
                    if(defeats[i]) d++;
                }
                if(d == num-1) break;

                int[] rspCounts = new int[3];
                
                // check each robot's rsp
                for(int i = 1; i <= num; i++){
                    if(defeats[i]) continue;

                    char rsp = robots[i][game];
                    if(rsp == 'R'){
                        rspCounts[0]++;
                    } else if(rsp == 'S'){
                        rspCounts[1]++;
                    } else{
                        rspCounts[2]++;
                    }
                }

                // check draw
                int drawCheck = 0;
                for(int cnt: rspCounts){
                    if(cnt == 0) drawCheck++;
                }
                if(drawCheck != 1) {
                    continue;
                }

                // check defeats
                if(rspCounts[0] == 0){
                    for(int robot = 1; robot <= num; robot++){
                        if(robots[robot][game] == 'P'){
                            defeats[robot] = true;
                        }
                    }
                } else if(rspCounts[1] == 0){
                    for(int robot = 1; robot <= num; robot++){
                        if(robots[robot][game] == 'R'){
                            defeats[robot] = true;
                        }
                    }
                } else{
                    for(int robot = 1; robot <= num; robot++){
                        if(defeats[robot]) continue;
                        if(robots[robot][game] == 'S'){
                            defeats[robot] = true;
                        }
                    }
                }
            }

            // count survivors
            int survivorsCount = 0;
            for(int i = 1; i <= num; i++){
                if(!defeats[i]) survivorsCount++;
            }

            // get result
            if(survivorsCount == 1){
                for(int i = 1; i <= num; i++){
                    if(!defeats[i]){
                        result = i;
                        break;
                    }
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}