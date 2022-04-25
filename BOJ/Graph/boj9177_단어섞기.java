package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class boj9177_단어섞기 {
    static char[] word1, word2, word3;
    static boolean result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            word1 = st.nextToken().toCharArray();
            word2 = st.nextToken().toCharArray();
            word3 = st.nextToken().toCharArray();
            result = false;
            bfs();

            if(result == true){
                System.out.println("Data set "+(i+1)+": yes");

            }else{
                System.out.println("Data set "+(i+1)+": no");

            }
        }
    }
    static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[word1.length+1][word2.length+1];
        q.offer(new Pair(0,0));

        visit[0][0] = true;

        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.x + cur.y == word3.length){
                result = true;
                break;
            }
            if(cur.x < word1.length && word3[cur.x+cur.y] == word1[cur.x]){
                if(visit[cur.x+1][cur.y] == false){
                    visit[cur.x+1][cur.y] = true;
                    q.offer(new Pair(cur.x+1, cur.y));
                }
            }
            if(cur.y < word2.length && word3[cur.x+cur.y] == word2[cur.y]){
                if(visit[cur.x][cur.y+1] == false){
                    visit[cur.x][cur.y+1] = true;
                    q.offer(new Pair(cur.x, cur.y+1));
                }
            }
        }
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
