import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    // static 변수들을 제거하고 main 내의 지역 변수로 모두 처리
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        // N도 main 내의 지역 변수로 선언
        int N = Integer.parseInt(br.readLine());
		
        // answer와 top도 지역 변수로 선언
        int answer = 0;
		int top = 0; // 스택의 현재 위치(인덱스)를 가리킴

        // 스택 배열도 지역 변수로 선언
        // 스택의 바닥(stack[0])을 0으로 사용하기 위해 N+1 크기 할당
		int[] stack = new int[N + 1]; 

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken(); // 첫 번째 토큰 (x좌표)은 무시
			int num = Integer.parseInt(st.nextToken()); // 두 번째 토큰 (y좌표)
			
            // 스택의 top에 있는 높이가 현재 높이(num)보다 높으면
            // 낮아질 때까지 pop (건물 종료)
			while (stack[top] > num) {
				top--;
				answer++; // pop할 때마다 완료된 건물로 카운트
			}

			// 스택의 top이 현재 높이(num)보다 낮으면 push (새 건물 시작)
            // (num이 0이고 stack[top]도 0이면 push되지 않음)
			if (stack[top] < num) {
				stack[++top] = num;
			}
            
            // stack[top] == num 이면 아무것도 하지 않음 (건물 이어짐)
		}
        
        // answer = 중간에 pop된 건물 수
        // top = 마지막까지 스택에 남아있는 건물 수 (stack[0] 제외)
		System.out.println(answer + top);

	}
}