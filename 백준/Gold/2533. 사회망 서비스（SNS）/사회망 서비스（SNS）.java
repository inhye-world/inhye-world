import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graphList;
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(br.readLine());

        StringTokenizer str;
        arr = new int[nodes+1][2];
        visited = new boolean[nodes+1];

        graphList = new ArrayList[nodes+1];
        for(int i = 1; i <= nodes; i++) {
            graphList[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < nodes; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());

            graphList[start].add(end);
            graphList[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(arr[1][0], arr[1][1]));
    }

    public static void dfs(int cur){
        visited[cur] = true;

        //현재 노드가 얼리어답터가 아닐때
        arr[cur][0] = 0;

        //현재 노드가 얼리어답터일 때
        arr[cur][1] = 1;

        for(int child : graphList[cur]){
            if(!visited[child]){
                dfs(child);
                arr[cur][0] += arr[child][1];
                arr[cur][1] += Math.min(arr[child][0], arr[child][1]);
            }
        }
    }
}
