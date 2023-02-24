import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ResultMinimumAbsoluteDifference {
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            int temp = arr.get(i + 1) - arr.get(i);
            if (min > temp) {
                min = temp;
            }
        }
        return min;
    }
}

public class MinimumAbsoluteDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultMinimumAbsoluteDifference.minimumAbsoluteDifference(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}
