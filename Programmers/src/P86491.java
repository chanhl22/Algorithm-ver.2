//class Solution50 {
//    public int solution(int[][] sizes) {
//        int answer = 0;
//        for (int i = 0; i < sizes.length; i++) {
//            int temp1 = sizes[i][0];
//            int temp2 = sizes[i][1];
//            sizes[i][0] = Math.max(temp1, temp2);
//            sizes[i][1] = Math.min(temp1, temp2);
//        }
//        int row = 0;
//        int col = 0;
//        for (int i = 0; i < sizes.length; i++) {
//            if (row < sizes[i][0]) {
//                row = sizes[i][0];
//            }
//            if (col < sizes[i][1]) {
//                col = sizes[i][1];
//            }
//        }
//        answer = row * col;
//        return answer;
//    }
//}

//Best Solution
class Solution50 {
    public int solution(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
}

public class P86491 {
    public static void main(String[] args) {
        Solution50 sol = new Solution50();
        int ans = 0;
        ans = sol.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println(ans);
    }
}