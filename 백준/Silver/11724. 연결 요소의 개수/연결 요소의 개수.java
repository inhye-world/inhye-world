import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       A = new ArrayList[N+1];
       visited = new boolean[N+1];

        //A노드 배열 선언https://www.acmicpc.net/problem/11724
        for(int i = 1; i <= N; i++){
            A[i] = new ArrayList<Integer>();
        }

        //A배열에 간선을 넣어준다.
        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        /* 확인
        for(int i = 1; i <= N; i++){
            System.out.print(A[i] + " ");
        }
        */

        //첫 노드를 시작으로 방문한다.
        cnt = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }

        System.out.print(cnt);
    }

    static void dfs(int v){
        if(visited[v]){
            return;
        }

        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
