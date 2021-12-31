package CodingTEST;

public class ebay_03 {
    static int count;

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        String bulbs = "RGG";

        int a = solution(n, k, bulbs);
        System.out.println(a);
    }

    public static int solution(int n, int k, String bulbs) {
        int answer = 0;
        count = 0;
        char[] arr = bulbs.toCharArray();
        // int idx = 0;
        while (true) {

            int idx = findnotR(arr);

            for (int i = 0; i < k; i++) {
                char tmp = changebulbs(arr[idx + i]);
                arr[idx + i] = tmp;
            }
            answer++;

            if (checkValue(arr) == true) {
                break;
            }

        }
        int check = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R') {
                check++;
            }
        }
        if (check != arr.length) {
            answer = -1;
        }
        return answer;
    }

    static int findnotR(char[] arr) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'R') {
                return i;
            }
        }
        return idx;
    }

    static boolean checkValue(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R') {
                count++;
            }
        }

        if (count == arr.length) {
            return true;
        }
        return false;
    }

    static char changebulbs(char c) {
        if (c == 'R') {
            return 'G';
        }
        if (c == 'G') {
            return 'B';
        }
        if (c == 'B') {
            return 'R';
        }
        return 'O';
    }
}
