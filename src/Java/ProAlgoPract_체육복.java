package Java;

import java.util.Arrays;

public class ProAlgoPract_체육복 {

    public static void main(String [] args) {
        int n = 5;
        int [] lost = { 1,2,4 };
        int [] reserve = { 1,3,5 };

        // 1번이 2번 빌려줌
        // 3번이 2번 또는 4번 빌려줌
        // 5번이 4번 빌려줌.

        int answer = solution( n, lost, reserve );
        System.out.println("체육시간에 참여할 수 있는 학생 수 : " +answer);
    }
    public static int solution (int n, int[] lost, int[] reserve) {
        int answer = n;

        answer -= lost.length;      // 전체 학생 수 - 체육복 잃어버린 학생 수
                                    // 수업을 들을 수 있는 학생의 수

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 오름차순 정렬 - 퀵 정렬? 이게 정렬해야 처리속도 ? 정렬
        // 90점 - 프로그래머스나 백준이나 이런데서는 알고리즘 문제 제출
        // 처리속도 (성능)
        // 90점

        // 이제 여벌 체육복이 있는 친구들이 빌려주면 answer의 값은 증가될 수 있음.

        for ( int i = 0; i < lost.length; i++) {
            for ( int j = 0; j < reserve.length; j++) {
                // **************************** 여벌 옷이 있는 학생이 도난당할 경우 **********************************
                // 문제를 끝까지 보는 습관을 들입시다.
                if( lost[i] == reserve[j] ) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        // System.out.println("여벌옷이 있는 학생이 도난당할 경우 고려한 이후\n배열 lost [] : " +Arrays.toString(lost)  );
        // System.out.println("여벌옷이 있는 학생이 도난당할 경우 고려한 이후\n배열 reserve [] : " +Arrays.toString(reserve)  );

        // System.out.print("\n여벌옷이 있는 학생이 다른 학생 빌려줄 경우");
        for ( int i = 0; i < lost.length; i++) {

            for ( int j = 0; j < reserve.length; j++) {
                if ( reserve[j] > 0 ) {
                    // 여벌 옷이 있는 학생이 도난당한 학생에게 빌려줄 경우.....

                     if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {

                         // System.out.println("lost [] : " + Arrays.toString(lost));
                         // System.out.println("reserve [] : " + Arrays.toString(reserve));

                         reserve[j] = -1;
                         // System.out.println("reserve [] : " + Arrays.toString(reserve));

                         answer++;
                         break;
                    }
                }
            }
            // System.out.println("");
        }
        // System.out.println(answer);

        return answer;
    }
}
