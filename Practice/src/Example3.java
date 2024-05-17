import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 소개 내용에 '좋아'가 몇 번 등장하는지 구하라
 * 13m 53s
 */

public class Example3 {
    public static void main(String[] args) {
        String input = input();
        List<List<String>> members = Arrays.stream(input.split("\n"))
                .skip(1)
                .map(member -> member.split(", "))
                .map(strings -> Arrays.stream(strings)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        // 좋아 카운트
        int sum = members.stream()
                .map(member -> member.get(2))
                .filter(introduce -> introduce.contains("좋아"))
                .map(strings -> (strings.length() - strings.replaceAll("좋아", "").length()) / 2)
                .mapToInt(i -> i)
                .sum();

        System.out.println(sum);
    }

    private static String input() {
        return "이름, 취미, 소개\n" +
                "김프로, 축구:농구:야구, 구기종목 좋아요\n" +
                "정프로, 개발:당구:족구, 개발하는데 뛰긴 싫어\n" +
                "앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아\n" +
                "죠르디, 스포츠댄스:개발, 개발하는 죠르디\n" +
                "찬희, 피아노:개발:스포츠댄스, 개발하는 찬희";
    }
}
