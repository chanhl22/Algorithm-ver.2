import java.util.*;

class Music {
    String genre;
    int play;
    int index;

    Music(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }
}

class Solution38 {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;

        //모든 장르와 재생 횟수 기록
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        //모든 장르를 넣을 순서대로 뽑아냄
        ArrayList<String> g = new ArrayList<>();
        while (!map.isEmpty()) {
            int max = 0;
            String max_str = "";
            for (String key : map.keySet()) {
                int cnt = map.get(key);
                if (max < cnt) {
                    max = cnt;
                    max_str = key;
                }
            }
            g.add(max_str);
            map.remove(max_str);
        }

        //뽑아낸 순서대로 맞는 장르에 대한 장르, 재생횟수, 인덱스를 기록
        ArrayList<Music> res = new ArrayList<>();
        for (int i = 0; i < g.size(); i++) {
            ArrayList<Music> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (g.get(i).equals(genres[j])) {
                    list.add(new Music(genres[j], plays[j], j));
                }
            }
            Collections.sort(list, (x, y) -> y.play - x.play);
            for (int j = 0; j < list.size(); j++) {
                if (j >= 2) {
                    break;
                }
                res.add(list.get(j));
            }
        }

        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i).index;
        }
        return answer;
    }
}


public class P42579 {
    public static void main(String[] args) {
        Solution38 sol = new Solution38();
        int[] ans = sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(ans));
    }
}