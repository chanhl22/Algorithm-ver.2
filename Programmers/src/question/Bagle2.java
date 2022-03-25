package question;

class Solution60 {
    public int solution(String catalogue) {
        String[] str = catalogue.split("\\n");
        int n = str.length;
        for (int i = 0; i < n; i++) {
            str[i] = str[i].trim();
        }
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = str[i].split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int range = arr[0][0];
        int count = arr[0][1];
        int stone = arr[0][2];
        int[] bag = new int[1000001];
        for (int i = 1; i <= count; i++) {
            int c = 0;
            for (int j = arr[i][0]; j <= arr[i][1]; j += arr[i][2]) {
                if (c == stone) {
                    break;
                }
                bag[j]++;
                c++;
            }
        }
        int answer = 0;
        int temp = stone;
        for (int i = 0; i < 1000001; i++) {
            if (bag[i] != 0) {
                temp -= bag[i];
                if (temp <= 0) {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}


public class Bagle2 {
    public static void main(String[] args) {
        Solution60 sol = new Solution60();
        int ans = 0;
        //ans = sol.solution("200 2 5 \n 100 150 10 \n 110 150 15");
        ans = sol.solution("300 5 31 \n 231 300 26 \n 44 52 1 \n 468 256 16 \n 225 242 5 \n 16 24 1" );
        System.out.println(ans);
    }
}