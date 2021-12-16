package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj1018_체스판다시칠하기 {
    static int N,M;
    static char[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visit;
    static int answer = Integer.MAX_VALUE;
    static char[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visit = new boolean[N][M];
        arr = new char[N][M];

        String[] input = new String[N];
        for(int i=0;i<N;i++){
            input[i] = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input[i].charAt(j);
            }
        }

        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                checkChess(i, j);
            }
        }
        System.out.println(answer);
    }
    static void checkChess(int x, int y){
        char value = map[x][y];
        int cnt = 0;
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if(map[i][j] != value){
                    cnt++;
                }
                if(value == 'W') value = 'B';
                else value= 'W';
            }
            if(value == 'W') value = 'B';
                else value= 'W';
        }
        answer = Math.min(answer, Math.min(cnt,64-cnt));
    }
}
