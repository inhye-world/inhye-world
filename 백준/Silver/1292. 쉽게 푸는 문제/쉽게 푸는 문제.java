import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];
        int count = 0;
        int sum = 0;
        //2 333 4
        for(int i = 1; i <= 1000; i++){
            for(int j = 0; j < i; j++){
                if(count == 1001) {
                    break;
                }
                arr[count] = i;
                count++;
            }
        }

        for (int j = start-1; j < end; j++) {
            sum = sum + arr[j];
        }
        System.out.print(sum);
    }
}
