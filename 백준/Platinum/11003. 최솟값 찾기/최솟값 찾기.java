import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> minDeque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while(!minDeque.isEmpty() && minDeque.peekLast()[0] > cur){
                minDeque.pollLast();
            }

            minDeque.offer(new int[]{cur, i});

            if(minDeque.peek()[1] <= i - L){
                minDeque.poll();
            }

            bw.write(minDeque.peek()[0] + " ");
        }
        bw.flush();
        bw.close();
    }
}
