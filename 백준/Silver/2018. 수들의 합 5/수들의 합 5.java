import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //자기 자신의 경우
        int cnt = 1;
        int start_idx = 1;
        int end_idx = 1;

        //1부터 더해주니까
        int sum = 1;

        while(end_idx != N){
            if(sum < N){
                end_idx++;
                sum = sum + end_idx;
            }else if(sum == N){
                cnt++;
                end_idx++;
                sum = sum + end_idx;
            }else if(sum > N){
                sum = sum - start_idx;
                start_idx++;
            }
        }

        System.out.println(cnt);
    }
}