import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] arr;
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        //사탕판을 하나씩 심어준다
        String line = "";
        for(int i = 0; i < N; i++){
            line = br.readLine();
            arr[i] = line.toCharArray();
        }

        //행
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                char swap = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = swap;
                checkEq();

                //원상복구
                swap = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = swap;
            }
        }

        //열
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                char swap = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = swap;

                max = Math.max(checkEq(), max);

                //원상복구
                swap = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = swap;
            }
        }
        System.out.println(max);
    }

    public static int checkEq(){
        //가로
        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 0; j < N-1; j++) {
                if (arr[i][j] == arr[i][j+1]){
                    cnt++;
                }else{
                    cnt  = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        //세로
        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 0; j < N-1; j++) {
                if (arr[j][i] == arr[j+1][i]){
                    cnt++;
                }else{
                    cnt  = 1;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
