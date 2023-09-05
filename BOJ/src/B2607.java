/**
 * playtime = 39:00
 * 맞긴 했는데 너무 어렵게 풀었음
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B2607 {
    private static int n;
    private static String[] input;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.next();
        }
    }

    private static void solution() {
        int result = 0;
        int[] mainChars = updateMainCharacterIndex();
        ArrayList<Integer> checkIndex = findMainCharacterIndex(mainChars);

        result = findSimilarWords(result, checkIndex);

        System.out.println(result);
    }

    private static int findSimilarWords(int result, ArrayList<Integer> checkIndex) {
        for (int i = 1; i < n; i++) {
            int[] subChars = updateSubCharacterIndex(i);
            checkSameCharacter(checkIndex, subChars);

            int sum = findDifferentSum(subChars);
            int count = findDifferentCount(subChars);
            boolean isOk = checkMoreThanTwo(subChars);
            if (sum >= -1 && sum <= 1 && count <= 2 && isOk) {
                result++;
            }
        }
        return result;
    }

    private static int[] updateMainCharacterIndex() {
        int[] mainChars = new int[26];
        for (int i = 0; i < input[0].length(); i++) {
            mainChars[input[0].charAt(i) - 'A']++;
        }
        return mainChars;
    }

    private static ArrayList<Integer> findMainCharacterIndex(int[] mainChars) {
        ArrayList<Integer> checkIndex = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (mainChars[i] > 0) {
                for (int j = 0; j < mainChars[i]; j++) {
                    checkIndex.add(i);
                }
            }
        }
        return checkIndex;
    }

    private static int[] updateSubCharacterIndex(int i) {
        int[] subChars = new int[26];
        for (int j = 0; j < input[i].length(); j++) {
            subChars[input[i].charAt(j) - 'A']++;
        }
        return subChars;
    }

    private static void checkSameCharacter(ArrayList<Integer> checkIndex, int[] subChars) {
        for (Integer index : checkIndex) {
            subChars[index]--;
        }
    }

    private static int findDifferentSum(int[] subChars) {
        int count = 0;
        for (int subChar : subChars) {
            if (subChar != 0) {
                count += subChar;
            }
        }
        return count;
    }

    private static int findDifferentCount(int[] subChars) {
        int count = 0;
        for (int subChar : subChars) {
            if (subChar != 0) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkMoreThanTwo(int[] subChars) {
        for (int subChar : subChars) {
            if (subChar > 1 || subChar < -1) {
                return false;
            }
        }
        return true;
    }
}
