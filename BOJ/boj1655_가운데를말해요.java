package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj1655_가운데를말해요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            q.offer(num);
        }
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            if (cnt == 1) {
                System.out.println(cur);
                list.add(cur);
            } else {
                if (cnt % 2 == 0) {
                    Collections.sort(list);
                    for (int i = 0; i < list.size(); i++) {
                        if (cnt <= 2) {
                            min = Math.min(cur, list.get(i));
                        } else {
                            int mid = list.size() / 2;
                            min = Math.min(list.get(mid), list.get(mid + 1));
                        }

                    }

                    System.out.println(min);
                    list.add(cur);
                } else {
                    list.add(cur);
                    Collections.sort(list);
                    int size = list.size();
                    int mid = size / 2;
                    // bw.write(list.get(mid));
                    System.out.println(list.get(mid));
                }
            }
        }
    }
}
