import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long cnt = 0;

        int[] arr = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0;  i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        long[] sum = new long[N];
        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        long[] r = new long[M];
        for(int i = 0; i < N; i++){
            //0~i번째 까지의 수 중에서 m의 배수인거
            int reminder = (int) (sum[i]%M);
            if( reminder == 0){
                cnt++;
            }

            r[reminder]++;
       }

        for(int i = 0;  i < M; i++) {
            if(r[i] > 1){
                //나머지가 같은 인덱스 중 2개 뽑는 경우의 수 n*(n-1)/2 : 학생때 배운거
                cnt = cnt + (r[i] * (r[i] - 1)/2);
            }
        }
        System.out.print(cnt);
    }
}
