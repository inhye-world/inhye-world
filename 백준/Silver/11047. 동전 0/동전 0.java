import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        //배열 만들어 준다.
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int j = N-1; j >= 0; j--){
            cnt += (K / arr[j]);
            K = (K % arr[j]);
        }

        System.out.println(cnt);
    }
}
