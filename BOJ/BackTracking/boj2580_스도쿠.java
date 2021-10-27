package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2580_스도쿠 {
    static int[][] map;
    //static int N,M;
    static int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    static Queue<Pair> zero;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        StringTokenizer st;
        zero = new LinkedList<>();
        //N = 9;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    zero.offer(new Pair(i,j));
                }
            }
        }

        solution(0);
        //System.out.println();
        if(solution(0) == true){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        }
        

    }

    public static boolean checkRow(int x, int y, int value) {
       for(int i=0;i<9;i++){
           if(i == y) continue;
           if(map[x][i] == value) return false;
       }
       return true;
    }

    public static boolean checkCol(int x, int y, int value) {
        for(int i=0;i<9;i++){
            if(i == x) continue;
            if(map[i][y] == value) return false;
        }
        return true;
    }

    public static boolean checkMap(int x, int y, int value) {
        int sizeX = (x/3)*3;
        int sizeY = (y/3)*3;
        for(int i=sizeX;i<sizeX+3;i++){
            for(int j=sizeY;j<sizeY+3;j++){
                if(map[i][j] == value){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean solution(int count){
        if ( count == zero.size()) return true;
        Pair cur = zero.poll();
        int x = cur.x;
        int y = cur.y;

        for(int i=1;i<=9;i++){
            if(checkCol(x, y, i) && checkRow(x, y, i) && checkMap(x, y, i)){
                map[x][y] = i;
                if(solution(count++)){
                    return true;
                }
                map[x][y] = 0;
            }
        }
        return false;
    }
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
