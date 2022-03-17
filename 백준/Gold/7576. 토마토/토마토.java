import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class tomatoSpot{
    int x;
    int y;

    tomatoSpot(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<tomatoSpot> q;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");

        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        int[][] box = new int[N][M];
        q = new LinkedList<tomatoSpot>();

        //box에 토마토를 하나씩 넣는다.
        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(str[j]);
                if(box[i][j] == 1){
                    //만약 익은 토마토라면 판에 넣어둔다.
                    q.add(new tomatoSpot(i, j));
                }
            }
        }
        System.out.println(bfs(box, N, M));
    }

    public static int bfs(int[][] box, int N, int M) {
        while (!q.isEmpty()) {
            tomatoSpot t = q.remove();

            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) {
                //익은 토마토의 위치에서 상하좌우로 움직이면서 확인
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (box[nx][ny] == 0) {
                        //토마토가 안익었으면 익은토마토 추가
                        q.add(new tomatoSpot(nx, ny));

                        //익은 날을 표시한다
                        box[nx][ny] = box[x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //안익은 토마토가 있으면
                if (box[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, box[i][j]);
            }
        }

        if (result == 1) {
            //토마토가 모두 익었으면
            return 0;
        } else {
            //걸린 일수는 최대 날짜에서 1을 빼줘야 함
            return result-1;
        }

    }
}
