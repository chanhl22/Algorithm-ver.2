import java.util.Arrays;

class Solution31 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int n = phone_book.length;
        for (int i = 1; i < n; i++) {
            boolean check = phone_book[i].startsWith(phone_book[i - 1]);
            if (check == true) {
                return false;
            }
        }
        return true;
    }
}

//HashMap Solution
//import java.util.HashMap;
//import java.util.Map;
//
//class Solution31 {
//    public boolean solution(String[] phoneBook) {
//        boolean answer = true;
//        Map<String, Integer> map = new HashMap<>();
//        for(int i = 0; i < phoneBook.length; i++) {
//            map.put(phoneBook[i], i);
//        }
//        for(int i = 0; i < phoneBook.length; i++) {
//            for(int j = 0; j < phoneBook[i].length(); j++) {
//                if(map.containsKey(phoneBook[i].substring(0,j))) {
//                    answer = false;
//                    return answer;
//                }
//            }
//        }
//        return answer;
//    }
//}

public class P42577 {
    public static void main(String[] args) {
        Solution31 sol = new Solution31();
        //boolean ans = sol.solution(new String[]{"119", "97674223", "1195524421"});
        boolean ans = sol.solution(new String[]{"123","456","789"});
        //boolean ans = sol.solution(new String[]{"12", "123", "1235", "567", "88"});
        System.out.println(ans);
    }
}
