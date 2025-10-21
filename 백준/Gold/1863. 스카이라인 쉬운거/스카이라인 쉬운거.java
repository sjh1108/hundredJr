import java.io.IOException; // System.in.read()를 위해 필요

class Main {
    static int N, answer;
	static int[] stack;
	static int top;
    
    // --- Fast I/O (커스텀 입력 메소드) ---
    static final int BUFFER_SIZE = 1 << 16; // 65536 바이트 (2^16)
    static byte[] buffer = new byte[BUFFER_SIZE];
    static int bufferPointer = 0, bytesRead = 0;

    /**
     * 버퍼가 비었을 때 System.in에서 바이트를 읽어와 채웁니다.
     */
    static void fillBuffer() throws IOException {
        bytesRead = System.in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1; // EOF (End Of File)
    }

    /**
     * 버퍼에서 1바이트를 읽습니다.
     */
    static byte read() throws IOException {
        if (bufferPointer == bytesRead) fillBuffer();
        return (bytesRead == -1) ? -1 : buffer[bufferPointer++];
    }

    /**
     * System.in에서 공백으로 구분된 다음 정수(int)를 읽습니다.
     * (음수도 처리 가능)
     */
    static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        
        // 1. 공백 문자(스페이스, 엔터 등) 건너뛰기
        while (c <= ' ') c = read();
        
        // 2. 부호(음수/양수) 확인
        boolean neg = (c == '-');
        if (neg) c = read();
        
        // 3. 숫자 읽기
        do {
            ret = ret * 10 + (c - '0');
        } while ((c = read()) >= '0' && c <= '9');
        
        if (neg) return -ret;
        return ret;
    }
    // --- End of Fast I/O ---


	public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 제거
		N = nextInt(); // 커스텀 메소드로 N 읽기
		
        int answer = 0;
		int top = 0;

		stack = new int[N + 1]; 

		for (int i = 0; i < N; i++) {
			// StringTokenizer st = new StringTokenizer(br.readLine()); // 제거
			nextInt(); // x좌표 (첫 번째 숫자)를 읽고 버림
			int num = nextInt(); // y좌표 (두 번째 숫자)를 읽음
            
			while (stack[top] > num) {
				top--;
				answer++;
			}
			if (stack[top] < num) {
				stack[++top] = num;
			}
		}
		System.out.println(answer + top);
	}
}