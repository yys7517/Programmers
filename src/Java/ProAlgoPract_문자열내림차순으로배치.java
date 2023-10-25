package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProAlgoPract_문자열내림차순으로배치 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String result = solution( s );
        System.out.println( result );
    }
    public static String solution(String s) {
        char [] Upper = new char[s.length()];
        char [] Lower = new char[s.length()];

        int Upperidx = 0;
        int Loweridx = 0;

        List<String> list = new ArrayList<String>();
        for ( int i = 0; i < s.length(); i++) {
            if ( Character.isUpperCase( s.charAt(i) ) ) {
                Upper[Upperidx] = s.charAt(i);
                Upperidx++;
            }
            else {
                Lower[Loweridx] = s.charAt(i);
                Loweridx++;
            }
        }
        Arrays.sort(Upper);
        Arrays.sort(Lower);
        System.out.println(Arrays.toString(Upper));
        System.out.println(Arrays.toString(Lower));

        String answer ="";

        // 내림차순은 큰 수부터
        // 문제에서 소문자가 대문자보다 크다고 했음

        // 소문자 먼저 출력
        // 소문자도 소문자 중에 큰 수부터 작은 수로 내림차순
        for ( int i = Lower.length - 1; i >= 0 ; i-- ) {
            if ( Lower[i] != '\0' ) {
                answer += Lower[i] + "";
            }
        }
        // 대문자 출력
        // 대문자도 대문자 중에 큰 수부터 작은 수로 내림차순
        for ( int i = Upper.length - 1; i >= 0 ; i-- ) {
            if ( Upper[i] != '\0' ) {
                answer += Upper[i] + "";
            }
        }
        System.out.println( answer );

        return answer;
    }
}
