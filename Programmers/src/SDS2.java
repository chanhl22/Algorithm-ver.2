import java.util.ArrayList;
import java.util.Scanner;

class Set {
    int x;
    int y;
    int z;

    public Set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class SDS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tc = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = sc.next();
            }
            ArrayList<Set> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        boolean ok = check(str[i], str[j], str[k]);
                        if (ok) {
                            list.add(new Set(i, j, k));
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int k = 0; k < list.size(); k++) {
                    boolean[] c = new boolean[n];
                    c[list.get(i).x] = true;
                    c[list.get(i).y] = true;
                    c[list.get(i).z] = true;
                    int cnt = 1;
                    for (int j = i + 1 + k; j < list.size(); j++) {
                        if (c[list.get(j).x] == false && c[list.get(j).y] == false && c[list.get(j).z] == false) {
                            c[list.get(j).x] = true;
                            c[list.get(j).y] = true;
                            c[list.get(j).z] = true;
                            cnt++;
                        }
                    }
                    if (ans < cnt) {
                        ans = cnt;
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
            tc++;
        }
    }

    private static boolean check(String s1, String s2, String s3) {
        for (int i = 0; i < 4; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                if (s2.charAt(i) != s3.charAt(i)) {
                    return false;
                }
            } else if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == s3.charAt(i) || s2.charAt(i) == s3.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
