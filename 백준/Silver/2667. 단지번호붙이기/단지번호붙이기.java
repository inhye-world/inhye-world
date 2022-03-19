import java.util.*;

class aptdir{
    int x;
    int y;
    aptdir(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int[][] apt;
    static boolean[][] visited;
    static int cnt;
    static ArrayList<Integer> result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<aptdir> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        apt = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            String input = sc.next();
            for(int j = 0; j < N; j++){
                apt[i][j] = input.charAt(j)-'0';
            }
        }

        cnt = 0;
        result = new ArrayList<>();
        q = new LinkedList<aptdir>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(apt[i][j] == 1 && !visited[i][j]){
                    cnt = 1;
                    q.add(new aptdir(i, j));
                    bfs();
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int a : result){
            System.out.println(a);
        }
    }

    static int bfs(){
        if(!q.isEmpty()) {
            aptdir cur = q.remove();
            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (apt[nx][ny] == 1 && !visited[nx][ny]) {
                        cnt++;
                        q.add(new aptdir(nx, ny));
                        bfs();
                    }
                }
            }
        }
        return cnt;
    }
}
