import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] A = new int[N][2];
        for(int i = 0; i < N; i++){
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, (s, e) -> {
            if(s[1] == e[1]){
                return s[0] - e[0];
            }
            return s[1] - e[1];
        });

        int cnt = 0;
        int end = -1;

        for(int i = 0; i < N; i++){
            if(A[i][0] >= end){
                end = A[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
