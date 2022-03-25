package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution59 {
    public String[] solution(String[] directory, String[] command) {
        ArrayList<String> tree = new ArrayList<>();
        for (int i = 0; i < directory.length; i++) {
            tree.add(directory[i]);
        }
        for (int i = 0; i < command.length; i++) {
            Collections.sort(tree);
            String[] temp = command[i].split(" ");
            if (temp[0].equals("mkdir")) {
                tree.add(temp[1]);
            } else if (temp[0].equals("cp")) {
                String str = "";
                for (int j = 0; j < tree.size(); j++) {
                    String t = tree.get(j);
                    if(t.contains(temp[1])) {
                        str = t;
                    }
                }
                str = str.replace(temp[1], "");
                char c = temp[1].charAt(temp[1].length() - 1);
                tree.add(temp[2] + c);
                tree.add(temp[2] + c + str);
            } else if (temp[0].equals("rm")) {
                tree.remove(temp[1]);
            }
        }

        String[] answer = new String[tree.size()];
        for (int i = 0; i < tree.size(); i++) {
            answer[i] = tree.get(i);
        }
        return answer;
    }
}


public class Bagle1 {
    public static void main(String[] args) {
        Solution59 sol = new Solution59();
        //String[] ans = sol.solution(new String[]{"/"}, new String[]{"mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c"});
        String[] ans = sol.solution(new String[]{"/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello"}, new String[]{"mkdir /root/temp", "cp /hello /root/temp", "rm /hello"});
        //String[] ans = sol.solution(new String[]{"/"}, new String[]{"mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "rm /a/b/c"});
        System.out.println(Arrays.toString(ans));
    }
}