import java.util.*;

class Edge{
    int edge;
    int val;

    public Edge(int edge, int val){
        this.edge = edge;
        this.val = val;
    }
}

public class Main {
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Edge>[] arr;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < N; i++){
            int s = sc.nextInt();
            while (true){
                int e = sc.nextInt();
                if(e == -1){
                    break;
                }
                int v = sc.nextInt();
                arr[s].add(new Edge(e, v));
            }
        }

        dist = new int[N+1];
        visited = new boolean[N+1];
        bfs(1);

        int max = 1;
        for(int i = 2; i <= N; i++){
            if(dist[max] < dist[i]){
                max = i;
            }
        }
        dist = new int[N+1];
        visited = new boolean[N+1];
        bfs(max);
        Arrays.sort(dist);
        System.out.println(dist[N]);
    }

    public static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while (!q.isEmpty()){
            int cur = q.poll();
            for(Edge i : arr[cur]){
                int e = i.edge;
                int v = i.val;
                if(!visited[e]){
                    visited[e] = true;
                    q.add(e);
                    dist[e] = dist[cur]+v;
                }
            }
        }
    }
}
