package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class boj17471_개리맨더링 {
    static int N;
    static int[] peopleN;
    static ArrayList<Integer>[] graph;
    static int[] select;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        peopleN = new int[N+1];
        graph = new ArrayList[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=N;i++){
            peopleN[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            for(int j=0;j<size;j++){
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        select = new int[N+1];
        combination(1);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
        
    }
    public static void combination(int index){
        if(index == N+1){
            int A = 0;
            int B = 0;
            for(int i=1;i<N+1;i++){
                if(select[i] == 1){
                    A += peopleN[i];
                } 
                else{
                    B += peopleN[i];
                }
            }
            visit = new boolean[N+1];
            int connectArea = 0;
            for(int i=1;i<N+1;i++){
                if(!visit[i]){
                    connect(i, select[i]);
                    connectArea++;
                }
            }
            if(connectArea == 2){
                result = Math.min(result, Math.abs(A-B));
            }
            return;
        }
        select[index] = 1;
        combination(index+1);
        select[index] = 2;
        combination(index+1);
    }
    public static void connect(int index, int areaNum){
        Queue<Integer> q = new LinkedList<>();
        visit[index] = true;
        q.offer(index);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<graph[cur].size();i++){
                int next = graph[cur].get(i);
                if(select[next] == areaNum){
                    if(visit[next] == false){
                        q.offer(next);
                        visit[next] = true;
                    }
                }
            }
        }
    }
}
