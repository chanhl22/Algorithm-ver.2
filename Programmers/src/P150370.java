/**
 * playtime = 38:20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Privacy {
    int date;
    String contract;

    public Privacy(int date, String contract) {
        this.date = date;
        this.contract = contract;
    }

    public int getDate() {
        return date;
    }

    public String getContract() {
        return contract;
    }
}

class Solution150370 {
    public int[] solution(String inputToday, String[] inputTerms, String[] inputPrivacies) {
        List<Integer> result = new ArrayList<>();

        int today = convertDate(inputToday);
        List<Privacy> privacies = convertPrivacy(inputPrivacies);
        HashMap<String, Integer> terms = convertTerm(inputTerms);

        for (int i = 0; i < privacies.size(); i++) {
            String contract = privacies.get(i).getContract();
            int date = privacies.get(i).getDate();
            int term = terms.get(contract);
            if (date + term <= today) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private HashMap<String, Integer> convertTerm(String[] inputTerms) {
        HashMap<String, Integer> terms = new HashMap<>();
        for (String inputTerm : inputTerms) {
            String[] str = inputTerm.split(" ");
            String contract = str[0];
            int term = Integer.parseInt(str[1]) * 28;
            terms.put(contract, term);
        }
        return terms;
    }

    private List<Privacy> convertPrivacy(String[] inputPrivacies) {
        List<Privacy> privacies = new ArrayList<>();
        for (String privacy : inputPrivacies) {
            String[] str = privacy.split(" ");
            int date = convertDate(str[0]);
            String contract = str[1];
            privacies.add(new Privacy(date, contract));
        }
        return privacies;
    }

    private int convertDate(String inputToday) {
        String[] str = inputToday.split("\\.");
        int y = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int d = Integer.parseInt(str[2]);
        return (y * 12 * 28) + (m * 28) + d;
    }
}

public class P150370 {
    public static void main(String[] args) {
        Solution150370 sol = new Solution150370();
        int[] ans = sol.solution("2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        System.out.println(Arrays.toString(ans));
    }
}