package CodingTEST;

public class ebay_02 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] stones = { 5, 7, 2, 4, 9 };
        int k = 20;
        solution(stones, k);
        // String str = "aaa";
        // char[] c = str.toCharArray();
    }

    public static String solution(int[] stones, int k) {
        String answer = "";
        System.out.println(stones.length);
        boolean visit = false;
        Outer: while (true) {
            if (checkValue(stones, k)) {
                break Outer;
            }
            findMin(stones, k);
            visit = false;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] == min && !visit) {
                    stones[i]++;
                    answer += i;
                    visit = true;
                    if (checkValue(stones, k)) {
                        break Outer;
                    }
                } else {
                    stones[i]--;
                }
            }

        }
        System.out.println(answer);
        return answer;
    }

    static int[] findMin(int[] stones, int k) {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == k - 1 || stones[i] == 0) {
                min = stones[i];
                return stones;
            }
            min = Math.min(min, stones[i]);
        }
        return stones;
    }

    static boolean checkValue(int[] stones, int k) {
        int idx = -1;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == k) {
                idx = i;
            }
        }
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (i != idx) {
                if (stones[i] == 0) {
                    count++;
                }
            }
        }
        if (count == stones.length - 1) {
            return true;
        }
        return false;
    }
}
