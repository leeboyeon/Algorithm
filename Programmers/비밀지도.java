package Programmers;

public class 비밀지도 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };
        String[] answer = new String[n];
        answer = solution(n, arr1, arr2);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] tmpArr1 = new int[n][n];
        int[][] tmpArr2 = new int[n][n];

        for (int i = 0; i < arr1.length; i++) {
            String value = Integer.toBinaryString(arr1[i]);
            if (value.length() < n) {
                value = "0" + value;
            }
            for (int j = 0; j < n; j++) {
                tmpArr1[i][j] = value.charAt(j) - '0';
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            String value = Integer.toBinaryString(arr2[i]);
            if (value.equals("1")) {
                value = "0001";
            }
            if (value.length() < n) {
                value = "0" + value;
            }

            for (int j = 0; j < value.length(); j++) {
                tmpArr2[i][j] = value.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmpArr1[i][j] == 0 && tmpArr2[i][j] == 1) {
                    tmpArr1[i][j] = 1;
                }
                if (tmpArr1[i][j] == 1 && tmpArr2[i][j] == 0) {
                    tmpArr1[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (tmpArr1[i][j] == 1) {
                    str += "#";
                } else if (tmpArr1[i][j] == 0) {
                    str += " ";
                }
            }
            answer[i] = str;
        }

        return answer;
    }
}
