package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 기지국 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            int N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            boolean[][] visit = new boolean[N][N];
            String str = "";
            int count = 0;
            for(int i=0;i<N;i++){
                str = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = str.charAt(j);
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] == 'A'){
                        visit[i][j] = true;
                        if(i-1>=0 && i-1<N){
                            visit[i-1][j] = true;
                        }
                        if(i+1>=0 && i+1<N){
                            visit[i+1][j] = true;
                        }
                        if(j-1>=0 && j-1<N){
                            visit[i][j-1] = true;
                        }
                        if(j+1>=0 && j+1<N){
                            visit[i][j+1] = true;
                        }
                    }
                    else if(map[i][j] == 'B'){
                        for(int go=1;go<=2;go++){
                            int iup = i+go;
                            int idown = i-go;
                            int jup = j+go;
                            int jdown = j-go;
                            visit[i][j] = true;
                            if(iup>=0 && iup<N){
                                visit[iup][j] = true;
                            }
                            if(idown>=0 && idown<N){
                                visit[idown][j] = true;
                            }
                            if(jup>=0 && jup<N){
                                visit[i][jup] = true;
                            }
                            if(jdown>=0 && jdown<N){
                                visit[i][jdown] = true;
                            }
                        }
                    }
                    else if(map[i][j] == 'C'){
                        for(int go=1;go<=3;go++){
                            int iup = i+go;
                            int idown = i-go;
                            int jup = j+go;
                            int jdown = j-go;
                            visit[i][j] = true;
                            if(iup>=0 && iup<N){
                                visit[iup][j] = true;
                            }
                            if(idown>=0 && idown<N){
                                visit[idown][j] = true;
                            }
                            if(jup>=0 && jup<N){
                                visit[i][jup] = true;
                            }
                            if(jdown>=0 && jdown<N){
                                visit[i][jdown] = true;
                            }
                        }
                    }else{
                        continue;
                    }
                }
            }
            
            // for(int i=0;i<N;i++){
            //     for(int j=0;j<N;j++){
            //         System.out.print(visit[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visit[i][j] == false && map[i][j] == 'H'){
                        count++;
                    }
                }
            }
            System.out.println("#"+tc+" "+count);
        }

    }
}
