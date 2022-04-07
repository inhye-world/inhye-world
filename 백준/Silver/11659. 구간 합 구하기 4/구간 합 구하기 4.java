import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] scores = br.readLine().split(" ");
        int N = Integer.parseInt(scores[0]);
        int t = Integer.parseInt(scores[1]);

        int[] arr = new int[N];
        String[] nums = br.readLine().split(" ");
        for(int i = 0;  i < N; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }

        int[] sum = new int[N+1];
        sum[0] = 0;
        for(int i = 1; i <= arr.length; i++){
            sum[i] = sum[i-1] + arr[i-1];
        }

        for(int i = 0;  i < t; i++){
            String[] range = br.readLine().split(" ");
            int a = Integer.parseInt(range[0]);
            int b = Integer.parseInt(range[1]);

            System.out.println(sum[b] - sum[a-1]);
        }
    }
}
