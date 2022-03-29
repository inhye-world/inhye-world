import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 0;
        //200은 10을 20개 더한 것
        //19개의 서로 다른 수를 더했다? 제일 작은 수부터 더해준다

        for(int i = 1; ; i++){
            if(sum > S){
                break;
            }
            sum += i;
            cnt++;
        }

        System.out.println(cnt-1);
    }
}
