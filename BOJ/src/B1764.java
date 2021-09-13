import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class B1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);
        HashSet<String> set = new HashSet<>();
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String listen = br.readLine();
            set.add(listen);
        }
        for (int i = 0; i < m; i++) {
            String see = br.readLine();
            if (set.contains(see)) {
                a.add(see);
            }
        }
        Collections.sort(a);
        System.out.println(a.size());
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < a.size(); i++) {
            sb.append(a.get(i));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
