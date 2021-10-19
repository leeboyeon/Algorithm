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
    static boolean[] select;
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

        select = new boolean[N+1];
        comb(1);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
        
    }
    public static void comb(int index){
        if(index == N+1){
            if(connect()){
                int sumA = 0;
                int sumB = 0;
                for(int i=1;i<N+1;i++){
                    if(select[i]){
                        sumA += peopleN[i];
                    }else{
                        sumB += peopleN[i];
                    }
                }
                result = Math.min(result, Math.abs(sumA - sumB));
            }
            return;
        }
        select[index] = true;
        comb(index+1);
        select[index] = false;
        comb(index+1);
    }
    public static boolean connect(){
        boolean[] visit = new boolean[N+1];

        int A = -1;
        for(int i=1;i<N+1;i++){
            if(select[i]){
                A = i;
                break;
            }
        }
        int B =-1;
        for(int i=1;i<N+1;i++){
            if(!select[i]){
                B = i;
                break;
            }
        }

        if(A == -1 || B == -1) return false;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);
        visit[A] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<graph[cur].size();i++){
                if(visit[graph[cur].get(i)] == true) continue;
                if(select[graph[cur].get(i)] == false) continue;
                visit[graph[cur].get(i)] = true;
                q.offer(graph[cur].get(i));
            }
        }

        q.offer(B);
        visit[B] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<graph[cur].size();i++){
                if(visit[graph[cur].get(i)] == true) continue;
                if(select[graph[cur].get(i)] == false) continue;
                visit[graph[cur].get(i)] = true;
                q.offer(graph[cur].get(i));
            }
        }

        for(int i=1;i<N+1;i++){
            if(!visit[i]) return false;
        }
        return true;
    }
}
