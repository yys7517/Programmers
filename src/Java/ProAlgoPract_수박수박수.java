package Java;

public class ProAlgoPract_수박수박수 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 6;
        String answer = s.solution(n);
        System.out.println(answer);
    }

}

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        // n = 5
        // 수박수박수
        // 수 3번, 박 2번

        for (int i = 0; i < n / 2; i++)
            sb.append("수박");

        if (n % 2 == 1)
            sb.append("수");


        return sb.toString();
    }
}
