class Solution48 {
    public int solution(int[] sortedArray, int findValue) {
        int answer = -1;
        // 배열의 첫번째 인덱스 값
        int left = 0;
        // 배열이라서 -1함
        int right = sortedArray.length - 1;
        int mid;
        while (left <= right) {
            // 중앙값을 계산
            mid = (left + right) / 2;
            if (findValue == sortedArray[mid]) {
                answer = mid;
                break;
            }
            // 찾고자 하는 KEY값이 배열의 중앙값보다 작을경우
            if (findValue < sortedArray[mid]) {
                // 데이터는 왼쪽에 위치함으로 right를 mid에서 1을 뺀 값으로 변경
                right = mid - 1;
            }
            // 찾고자 하는 KEY값이 배열의 중앙값보다 클 경우
            else {
                //데이터는 오른쪽에 위치함으로 left값을 mid에서 1을 더한 값으로 변경
                left = mid + 1;
            }
        }
        return answer;
    }
}


public class C2 {
    public static void main(String[] args) {
        Solution48 sol = new Solution48();
        int ans = 0;
        //ans = sol.solution(new int[]{1, 2, 5, 7, 10, 15, 18, 20}, 15);
        ans = sol.solution(new int[]{1, 2, 5, 7, 10, 15, 18, 20}, 17);
        System.out.println(ans);
    }
}