import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < 10; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            int cur = -a +b;
            sum += cur;
            max = sum > max ? sum : max;
        }
        System.out.println(max);
    }
}
