import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class spot{
    int x;
    int y;

    spot(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static Queue<spot> q;
    //static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j)-'0';
            }
        }

        q.add(new spot(0,0));
        bfs();

        System.out.println(arr[N-1][M-1]);
    }

    static void bfs(){
        while (!q.isEmpty()) {
            spot spot = q.remove();

            int x = spot.x;
            int y = spot.y;

            visited[x][y] =true;
            for(int i = 0; i < 4; i++) {
                int nx = x +dx[i];
                int ny = y +dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new spot(nx, ny));
                        visited[nx][ny] =true;
                        arr[nx][ny] = arr[x][y] + 1;
                    }
                }
            }
        }
    }
}
