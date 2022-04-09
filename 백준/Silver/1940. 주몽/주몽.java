import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int arrn[] = new int[N];

        String[] str = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            arrn[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arrn);

        int cnt = 0;
        int start_idx = 0;
        int end_idx = N - 1;

        while(start_idx < end_idx){
            if(arrn[start_idx]+arrn[end_idx] > M){
                end_idx--;
            } else if(arrn[start_idx]+arrn[end_idx] < M){
                start_idx++;
            } else {
                cnt++;
                start_idx++;
                end_idx--;
            }
        }

        System.out.println(cnt);
    }
}
