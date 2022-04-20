import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    public static void dfs(int n, int jari){
        if(jari == N){
            if(check(n)){
                System.out.println(n);
            }
            return;
        }

        for(int i = 1; i < 10; i++){
            if(i % 2 == 0){
                continue;
            }
            if(check(n*10+i)) {
                dfs(n * 10 + i, jari + 1);
            }
        }
    }

    public static boolean check(int n){
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
