import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);

        int[][] arr = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(arr, visited, V);

        System.out.println();

        visited = new boolean[N+1];
        bfs(arr, visited, V);
    }

    static void dfs(int[][] arr, boolean[] visited, int V){
        visited[V] = true;
        System.out.print(V+" ");

        for(int i = 0; i < arr[V].length; i++){
            if(arr[V][i] == 1 && !visited[i]){
                dfs(arr, visited, i);
            }
        }
    }

    static void bfs(int[][] arr, boolean[] visited, int V){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;

        while (!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");

            for(int i = 0; i < arr.length; i++){
                if(arr[temp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
