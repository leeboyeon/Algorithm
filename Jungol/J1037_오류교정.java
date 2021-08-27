package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1037_오류교정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int Xsum = 0;
        int Ysum = 0;
        int[] row = new int[size];
        int[] col = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Xsum += arr[i][j];
                Ysum += arr[j][i];
            }
            row[i] = Xsum;
            col[i] = Ysum;
            Xsum = 0;
            Ysum = 0;
        }
        int xidx = 0;
        int yidx = 0;
        int rowcnt = 0;
        for (int i = 0; i < size; i++) {
            if (row[i] % 2 != 0) {
                xidx = i;
                rowcnt++;
            }
        }
        
        int colcnt = 0;
        for (int i = 0; i < size; i++) {
            if (col[i] % 2 != 0) {
                yidx = i;
                colcnt++;
            }
        }

        if (rowcnt == 0 && colcnt == 0) {
            System.out.println("OK");
        } else if (rowcnt == colcnt) {
            System.out.println("Change bit (" + (xidx + 1) + "," + (yidx + 1) + ")");
        } else if (rowcnt > 1 || colcnt > 1) {
            System.out.println("Corrupt");
        }

    }
}
