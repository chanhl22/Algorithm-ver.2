import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 취미별 정씨 성을 갖는 멤버 수를 구하라
 * 19m 47s
 */

public class Example2 {
    public static void main(String[] args) {
        String input = input();
        List<List<String>> members = Arrays.stream(input.split("\n"))
                .skip(1)
                .map(member -> member.split(", "))
                .map(strings -> Arrays.stream(strings)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        // 취미 리스트
        List<String> hobbys = members.stream()
                .map(member -> member.get(1))
                .map(hobby -> Arrays.stream(hobby.split(":"))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        // key = 정씨가 가지는 취미, value = 합계
        Map<String, Long> result = members.stream()
                .filter(member -> member.get(0).startsWith("정"))
                .map(member -> member.get(1))
                .map(hobby -> Arrays.stream(hobby.split(":"))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String hobby : hobbys) {
            System.out.println("취미 = " + hobby);
            System.out.println("정씨 맴버 수 = " + result.getOrDefault(hobby, 0L));
            System.out.println("================");
        }
    }

    private static String input() {
        return "이름, 취미, 소개\n" +
                "김프로, 축구:농구:야구, 구기종목 좋아요\n" +
                "정프로, 개발:당구:족구, 개발하는데 뛰긴 싫어\n" +
                "앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아\n" +
                "죠르디, 스포츠댄스:개발, 개발하는 죠르디\n" +
                "정찬희, 피아노:개발:스포츠댄스, 개발하는 찬희";
    }
}
