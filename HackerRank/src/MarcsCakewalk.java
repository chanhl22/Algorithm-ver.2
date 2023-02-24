import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ResultMarcsCakewalk {
    public static long marcsCakewalk(List<Integer> calorie) {
        calorie.sort((o1, o2) -> o2 - o1);
        return calculateCalorie(calorie);
    }

    private static long calculateCalorie(List<Integer> calorie) {
        long result = 0L;
        for (int i = 0; i < calorie.size(); i++) {
            result += calorie.get(i) * Math.pow(2, i);
        }
        return result;
    }
}

public class MarcsCakewalk {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> calorie = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = ResultMarcsCakewalk.marcsCakewalk(calorie);
        System.out.println(result);

        bufferedReader.close();
    }
}
