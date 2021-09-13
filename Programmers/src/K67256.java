class Solution4 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int n = numbers.length;
        char[] arr = new char[n];

        int right_x = 3;
        int right_y = 2;
        int left_x = 3;
        int left_y = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                arr[i] = 'L';
                if (numbers[i] == 1) {
                    left_x = 0;
                    left_y = 0;
                } else if (numbers[i] == 4) {
                    left_x = 1;
                    left_y = 0;
                } else if (numbers[i] == 7) {
                    left_x = 2;
                    left_y = 0;
                }
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                arr[i] = 'R';
                if (numbers[i] == 3) {
                    right_x = 0;
                    right_y = 2;
                } else if (numbers[i] == 6) {
                    right_x = 1;
                    right_y = 2;
                } else if (numbers[i] == 9) {
                    right_x = 2;
                    right_y = 2;
                }
            } else {
                if (numbers[i] == 2) {
                    //0,1
                    if(Math.abs(right_x - 0) + Math.abs(right_y - 1) < Math.abs(left_x - 0) + Math.abs(left_y - 1)){
                        right_x = 0;
                        right_y = 1;
                        arr[i] = 'R';
                    } else if(Math.abs(right_x - 0) + Math.abs(right_y - 1) > Math.abs(left_x - 0) + Math.abs(left_y - 1)) {
                        left_x = 0;
                        left_y = 1;
                        arr[i] = 'L';
                    } else {
                        if(hand.equals("right")){
                            right_x = 0;
                            right_y = 1;
                            arr[i] = 'R';
                        } else if (hand.equals("left")){
                            left_x = 0;
                            left_y = 1;
                            arr[i] = 'L';
                        }
                    }
                } else if (numbers[i] == 5) {
                    //1,1
                    if(Math.abs(right_x - 1) + Math.abs(right_y - 1) < Math.abs(left_x - 1) + Math.abs(left_y - 1)){
                        right_x = 1;
                        right_y = 1;
                        arr[i] = 'R';
                    } else if(Math.abs(right_x - 1) + Math.abs(right_y - 1) > Math.abs(left_x - 1) + Math.abs(left_y - 1)) {
                        left_x = 1;
                        left_y = 1;
                        arr[i] = 'L';
                    } else {
                        if(hand.equals("right")){
                            right_x = 1;
                            right_y = 1;
                            arr[i] = 'R';
                        } else if (hand.equals("left")){
                            left_x = 1;
                            left_y = 1;
                            arr[i] = 'L';
                        }
                    }
                } else if (numbers[i] == 8) {
                    //2,1
                    if(Math.abs(right_x - 2) + Math.abs(right_y - 1) < Math.abs(left_x - 2) + Math.abs(left_y - 1)){
                        right_x = 2;
                        right_y = 1;
                        arr[i] = 'R';
                    } else if(Math.abs(right_x - 2) + Math.abs(right_y - 1) > Math.abs(left_x - 2) + Math.abs(left_y - 1)) {
                        left_x = 2;
                        left_y = 1;
                        arr[i] = 'L';
                    } else {
                        if(hand.equals("right")){
                            right_x = 2;
                            right_y = 1;
                            arr[i] = 'R';
                        } else if (hand.equals("left")){
                            left_x = 2;
                            left_y = 1;
                            arr[i] = 'L';
                        }
                    }
                }else if (numbers[i] == 0) {
                    //3,1
                    if(Math.abs(right_x - 3) + Math.abs(right_y - 1) < Math.abs(left_x - 3) + Math.abs(left_y - 1)){
                        right_x = 3;
                        right_y = 1;
                        arr[i] = 'R';
                    } else if(Math.abs(right_x - 3) + Math.abs(right_y - 1) > Math.abs(left_x - 3) + Math.abs(left_y - 1)) {
                        left_x = 3;
                        left_y = 1;
                        arr[i] = 'L';
                    } else {
                        if(hand.equals("right")){
                            right_x = 3;
                            right_y = 1;
                            arr[i] = 'R';
                        } else if (hand.equals("left")){
                            left_x = 3;
                            left_y = 1;
                            arr[i] = 'L';
                        }
                    }
                }
            }
        }
        answer = String.valueOf(arr);
        return answer;
    }
}

public class K67256 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        int[] a = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String ans = sol.solution(a, "right");
        System.out.println(ans); //"LRLLLRLLRRL"
    }
}