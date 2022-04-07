import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] scores = br.readLine().split(" ");
        long M = 0;
        for(int i = 0;  i < N; i++){
            arr[i] = Integer.parseInt(scores[i]);
            if(arr[i] >= M){
                M = arr[i];
            }
        }

        long sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        System.out.println((sum*100.0)/M/N);
    }
}
