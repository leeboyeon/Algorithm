package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2660_회장뽑기 {
    static int[][] map;
    static int N;
    static int INF = 2000001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int a = 0;
        int b = 0;

        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i!=j){
                    map[i][j] = INF;
                }
            }
        }


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == -1 && b== -1){
                break;
            }
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        for(int via = 1;via <= N; via++){
            for(int from = 1; from <= N;from++){
                for(int to = 1; to<= N; to++){
                    if(from == to) continue;
                    if(map[from][via] != 0 && map[via][to] != 0){
                        if(map[from][to] == 0){
                            map[from][to] = map[from][via] + map[via][to];
                        }else if(map[from][to] > map[from][via] + map[via][to]){
                            map[from][to] = map[from][via]+map[via][to];
                        }
                    }
                    
                }
            }
        }
        int score = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                score = Math.max(score, map[i][j]);
            }
            list.add(score);
            score = 0;
        }
        int bestScore = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            bestScore = Math.min(bestScore, list.get(i));
        }
        int candidateNum = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i) == bestScore){
                candidateNum++;
            }
        }
        System.out.println(bestScore+" "+candidateNum);

        for(int i=0;i<list.size();i++){
            if(list.get(i) == bestScore){
                System.out.print((i+1)+" ");
            }
        }
    }
}
