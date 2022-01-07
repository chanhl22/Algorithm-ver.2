//playtime = 9:39

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null) {
            int[] arr = new int[4];
            for (int i = 0; i < input.length(); i++) {
                // 소문자
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    arr[0] += 1;
                }
                // 대문자
                else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    arr[1] += 1;
                }
                // 숫자
                else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    arr[2] += 1;
                }
                // 공백
                else {
                    arr[3] += 1;
                }
            }
            for (int i = 0; i < 4; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}