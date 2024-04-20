/**
 * 숫자 카드 나누기
 * playtime = 35m 20s
 */

public class P135807 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(new int[]{10, 17}, new int[]{5, 20});
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int gcdA = arrayA[0];
            for (int i = 1; i < arrayA.length; i++) {
                gcdA = gcd(gcdA, arrayA[i]);
            }

            int gcdB = arrayB[0];
            for (int i = 1; i < arrayB.length; i++) {
                gcdB = gcd(gcdB, arrayB[i]);
            }

            boolean isB = true;
            for (int k : arrayA) {
                if (k % gcdB == 0) {
                    isB = false;
                    break;
                }
            }

            boolean isA = true;
            for (int j : arrayB) {
                if (j % gcdA == 0) {
                    isA = false;
                    break;
                }
            }

            if (isB && isA) {
                return Math.max(gcdA, gcdB);
            } else if (isB) {
                return gcdB;
            } else if (isA) {
                return gcdA;
            } else {
                return 0;
            }
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            return a;
        }
    }
}
/**
 * 10 20
 * 15 17
 * 10으로 나눠지는데 5로 안나눠지는 경우는 없음
 */