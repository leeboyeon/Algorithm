package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj1446_지름길 {
    static class Pair{
        int s;
        int g;
        int v;
        public Pair(int s, int g, int v){
            this.s = s;
            this.g = g;
            this.v = v;
        }
    }
    static ArrayList<Pair> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
            
        map = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(g > D) continue;
            if(g-s <= v) continue;

            map.add(new Pair(s,g,v));    
        }

        Collections.sort(map, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                if(p1.s == p2.s) return p1.g - p2.g;
                return p1.s - p2.s;
            }
        });
        
        for(int i=0;i<map.size();i++){
            System.out.println(map.get(i).s +" "+map.get(i).g+" "+map.get(i).v);
        }
        
        int index = 0;
        int lastPoint = 0;
        int sum = 0;
        int size = 0;
        while(true){
            Pair cur = map.get(index);
            size--;
            if(cur.s < lastPoint){
                lastPoint = cur.g - cur.s;
                sum += cur.v; 
            }
            if(lastPoint == D){
                System.out.println(sum);
                break;
            }
            if(size == 0){
                sum = sum +(D-lastPoint);
                System.out.println(sum);
                break;
            }

        }
    }
}
