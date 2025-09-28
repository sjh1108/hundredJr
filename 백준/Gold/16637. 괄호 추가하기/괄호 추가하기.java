import java.io.*;
import java.util.*;

class Main {
    static int ans;
    static ArrayList<Character> ops;
    static ArrayList<Integer> nums;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
 
        ops = new ArrayList<>();
        nums = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                continue;
            }
            nums.add(Character.getNumericValue(c));
        }
 
        ans = Integer.MIN_VALUE;
        dfs(nums.get(0), 0);
 
        System.out.println(ans);
    }
 
    // 연산
    public static int calc(char op, int n1, int n2) {
        switch (op) {
        case '+':
            return n1 + n2;
        case '-':
            return n1 - n2;
        case '*':
            return n1 * n2;
        }
        return -1;
    }
 
    public static void dfs(int result, int idx) {
        if (idx == ops.size()) {
            ans = Math.max(ans, result);
            return;
        }
 
        // 괄호가 없는 경우
        int res = calc(ops.get(idx), result, nums.get(idx + 1));
        dfs(res, idx + 1);
 
        // 괄호가 있는 경우
        if (idx + 1 < ops.size()) {
            // result의 오른쪽에 있는 값을 연산함.
            res = calc(ops.get(idx + 1), nums.get(idx + 1), nums.get(idx + 2));
 
            // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
            dfs(calc(ops.get(idx), result, res), idx + 2);
        }
    }
 
}