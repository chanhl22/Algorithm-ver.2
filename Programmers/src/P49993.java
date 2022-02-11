//playtime = 43:37
//위상정렬 문제인줄 알았는데 단순히 문자열 비교 문제였음;;

import java.util.*;

class Solution95 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Integer>[] list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        int n = skill.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list[skill.charAt(i) - 'A'].add(skill.charAt(j) - 'A');
            }
        }
        int m = skill_trees.length;
        for(int i = 0 ; i < m; i++) {
            int[] inDegree = new int[26];
            for (int k = 0, j = 0; k < n; k++) {
                inDegree[skill.charAt(k) - 'A'] = j++;
            }
            String temp = skill_trees[i];
            if (check(inDegree, temp, list)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean check(int[] inDegree, String str, ArrayList<Integer>[] list) {
        int n = str.length();
        for(int i = 0; i < n; i++) {
            if (inDegree[str.charAt(i) - 'A'] != 0) {
                return false;
            }
            for (int next : list[str.charAt(i) - 'A']) {
                inDegree[next]--;
            }
        }
        return true;
    }
}

//Another Solution
//class Solution95 {
//    int checker(String skill, String skill_tree){
//        int index = 0;
//        for(int j = 0; j < skill.length(); j++){
//            for(int k = 0; k < skill_tree.length(); k++){
//                if(skill.charAt(j) == skill_tree.charAt(k)){
//                    if(index > k){
//                        return 0;
//                    }
//                    break;
//                }
//                if(index <= k){
//                    index = k + 1;
//                }
//            }
//        }
//        return 1;
//    }
//
//    public int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//
//        for(int i = 0; i < skill_trees.length; i++){
//            answer = answer + checker(skill, skill_trees[i]);
//        }
//        return answer;
//    }
//}

public class P49993 {
    public static void main(String[] args) {
        Solution95 sol = new Solution95();
        int ans = 0;
        ans = sol.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(ans);
    }
}