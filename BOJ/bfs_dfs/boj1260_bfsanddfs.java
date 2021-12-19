package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260_bfsanddfs {

    static int N,V,M;
    static int[][] graph;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visit = new boolean[N+1];
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        dfs(V);
        System.out.println();
        visit = new boolean[N+1];
        bfs(V);
    }  
    static void dfs(int v){
        visit[v] = true;
        
        System.out.print(v+" ");
        for(int i=1;i<N+1;i++){
            if(graph[v][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }     

    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur+" ");
            for(int i=1;i<N+1;i++){
                if(graph[cur][i] == 1 && visit[i] == false){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
