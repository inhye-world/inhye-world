import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class sharkdir{
    int x;
    int y;

    sharkdir(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] arr;
    static int[][] dis;
    static int[] dx = {-1, 1, 0, 0, 1, -1, -1, 1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static Queue<sharkdir> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        arr = new int[N][M];
        dis = new int[N][M];
        q = new LinkedList<sharkdir>();

        for(int i = 0; i < N; i++){
            str= br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(str[j]);
                dis[i][j] = Integer.MAX_VALUE;
                if(arr[i][j] == 1){
                    //아기 상어가 있는 칸
                    q.add(new sharkdir(i, j));
                    dis[i][j] = 0;
                }
            }
        }
        System.out.println(bfs(arr, N, M));
    }

    static int bfs(int[][] arr, int N, int M){
        int result = 0;

        while(!q.isEmpty()){
            sharkdir sd = q.remove();

            int x = sd.x;
            int y = sd.y;

            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(dis[nx][ny] > dis[x][y]+1) {
                        dis[nx][ny] = dis[x][y] + 1;

                        q.add(new sharkdir(nx, ny));
                        result = Math.max(dis[nx][ny], result);
                    }
                }
            }
        }

        return result;
    }
}
