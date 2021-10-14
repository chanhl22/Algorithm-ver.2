import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class B1544{
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int i, n = Integer.parseInt(in.readLine());

        HashSet<String> hs = new HashSet<>(); //단어 저장소
        hs.add(in.readLine()); //맨 첫번째 단어 저장

        /* 두번째 단어부터 검증 */
        for(i=1;i<n;i++) check(hs, in.readLine());

        /* 저장소의 크기 = 서로다른 단어의 개수 */
        out.write(String.valueOf(hs.size()));
        out.close();
        in.close();
    }
    private static void check(HashSet<String> hs, String word){
        int i, n = word.length();
        StringBuilder sb;

        for(String str : hs){
            sb = new StringBuilder(str);
            for(i=0;i<n;i++){
                /* 서로 같은 단어이면 종료 */
                if(word.equals(sb.toString())) return;

                    //다르다면 단어의 맨 앞 글자를 맨 뒤에 붙이고, 맨 앞글자 삭제
                    // ex) fish -> fishf -> ishf
                else sb = sb.append(sb.charAt(0)).deleteCharAt(0);
            }
        }
        //저장소의 단어들과 일치하지 않으면 저장소에 해당 단어 저장
        hs.add(word);
    }
}

//import java.util.Scanner;
//
//public class B1544 {
//    static boolean compare(String a, String b) {
//        int n = a.length();
//        boolean ok = false;
//        for (int i = 0; i < n; i++) {
//            if (a.charAt(0) == b.charAt(i)) {
//                boolean equal = true;
//                for (int j = 0; j < n; j++) {
//                    if (a.charAt(j) != b.charAt((i + j) % n)) {
//                        equal = false;
//                        break;
//                    }
//                }
//                if (equal) {
//                    ok = true;
//                }
//            }
//        }
//        return ok;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] str = new String[n];
//        for (int i = 0; i < n; i++) {
//            str[i] = sc.next();
//        }
//        boolean[] c = new boolean[n];
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            if (c[i] == true) continue;
//            c[i] = true;
//            cnt++;
//            for (int j = i + 1; j < n; j++) {
//                if (c[j] == true) continue;
//                if (str[i].length() != str[j].length()) continue;
//                c[j] = compare(str[i], str[j]);
//            }
//        }
//        System.out.println(cnt);
//    }
//}