package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.metal.MetalBorders.ToggleButtonBorder;

public class boj19638_센티와마법의뿅망치 {
    static int N, H, T;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        list = new int[N];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            list[i] = value;
        }

        int hit = 0;
        boolean flag = false;

        while (true) {
            if (hit == T) {
                if (flag == true) {
                    System.out.println("YES");
                    System.out.println(hit);
                    break;
                } else {
                    System.out.println("NO");
                    System.out.println(findMax(list));
                    break;
                }
            }
            int max = findMax(list);
            for (int i = 0; i < N; i++) {
                ++hit;

                if (max == list[i]) {
                    list[i] -= H;
                }

                if (list[i] < H) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }

    }

    static int findMax(int[] list) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(list[i], max);
        }

        return max;
    }

    static boolean endGame(int[] list) {
        for (int i = 0; i < N; i++) {
            if (list[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
