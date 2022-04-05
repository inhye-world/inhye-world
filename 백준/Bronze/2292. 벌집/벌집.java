import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int end = 2;
        int n = 1;

        if(N==1){
            System.out.print(1);
        }else {
            while (end <= N) {
                end += (6 * n);
                n++;
            }
            System.out.print(n);
        }
    }
}
