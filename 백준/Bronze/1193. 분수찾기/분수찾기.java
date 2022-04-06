import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cur_idx = 1;
        int prev_idx = 0;
        while(true){
            if(N <= (prev_idx+cur_idx)) {
                if (cur_idx % 2 == 0) {
                    System.out.println((N - prev_idx) + "/" + ( cur_idx + 1 - N + prev_idx));
                    break;
                } else {
                    System.out.println((cur_idx + 1 - N + prev_idx) + "/" + (N - prev_idx));
                    break;
                }
            }else{
                prev_idx += cur_idx;
                cur_idx++;
            }
        }

    }
}
