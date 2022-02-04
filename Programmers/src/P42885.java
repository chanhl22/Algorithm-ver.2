//playtime = 30:09

import java.util.Arrays;

class Solution91 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        Arrays.sort(people);
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            answer++;
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }
        return answer;
    }
}

public class P42885 {
    public static void main(String[] args) {
        Solution91 sol = new Solution91();
        int ans = 0;
        ans = sol.solution(new int[]{40, 40, 50, 60 ,90}, 100);
        System.out.println(ans);
    }
}