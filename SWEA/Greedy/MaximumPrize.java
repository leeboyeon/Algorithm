package SWEA.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumPrize {
   static int result;
   static int cnt = 0;
   static int chance;
   static int[] arr = new int[6];
   static int max = 0;
   static boolean sorted = false;

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int T = Integer.parseInt(br.readLine());
      for (int tc = 1; tc <= T; tc++) {
         result = 0;
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         int N = Integer.parseInt(st.nextToken());
         // String input = st.nextToken();
         chance = Integer.parseInt(st.nextToken());
         String s = N + "";
         int len = (int) Math.log10(N) + 1;
         arr = new int[len];

         for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(s.substring(i, i + 1));
         }

         findThemax(0, 0);
         bw.write("#" + tc + " " + result);
         bw.newLine();

      }
      bw.flush();
      bw.close();
   }

   public static void findThemax(int cnt, int cur) {

      if (cur > arr.length) {
         return;
      }

      if (cnt == chance) {
         String temp = "";
         for (int i = 0; i < arr.length; i++) {
            temp = temp + arr[i];
         }
         if (result < Integer.parseInt(temp)) {
            result = Integer.parseInt(temp);
         }
         return;
      }
      for (int i = cur; i < arr.length; i++) {
         for (int j = i; j < arr.length; j++) {
            if (i == j)
               continue;
            if (arr[i] <= arr[j]) {
               swap(arr[i], arr[j], i, j);
               findThemax(cnt + 1, i);
               swap(arr[i], arr[j], i, j);
            } else {
               swap(arr[i], arr[j], i, j);
               findThemax(cnt + 1, i);
            }
         }
      }
   }

   public static void swap(int a, int b, int i, int j) {
      arr[j] = a;
      arr[i] = b;
   }
}