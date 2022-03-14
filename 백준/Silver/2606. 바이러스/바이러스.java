import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //컴퓨터 전체 수
        int N = Integer.parseInt(br.readLine());

        //네트웨크 연결 수
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        dfs(arr, visited, 1);
        System.out.println(answer-1);
    }

    public static void dfs(int[][] arr, boolean[] visited, int V){
        if (visited[V]) {
            return;
        }

        visited[V] = true;
        answer++;

        for(int j = 0; j < arr[V].length; j++) {
            //연결은 되어있는데, 방문하지 않았다면 재귀
            if(arr[V][j] == 1 && !visited[j]) {
                dfs(arr, visited, j);
            }
        }
    }
}