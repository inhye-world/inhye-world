import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int N;
    static boolean arrive;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        arrive = false;

        for(int i = 0;  i < N; i++){
            arr[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            dfs(i, 1);
            if(arrive){
                break;
            }
        }

        if(arrive){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

    public static void dfs(int v, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[v] = true;
        for(int i : arr[v]) {
            if(!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[v] = false;
    }
}
