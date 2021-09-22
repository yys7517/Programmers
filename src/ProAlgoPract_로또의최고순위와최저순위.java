import java.util.Arrays;

public class ProAlgoPract_로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos = { 44,1,0,0,31,25 };
        int[] win_nums = { 31,10,45,1,6,19 };

        int[] rank = solution( lottos,win_nums );

        System.out.println(Arrays.toString(rank) );
    }
    public static int[] solution ( int[] lottos, int[] win_nums ) {

        int[] answer = new int[2];
        int matched = 0;        // 일치
        int zero = 0;           // 0의 갯수

        for ( int i = 0; i < lottos.length; i++ ) {
            for ( int j = 0; j < win_nums.length; j++ ) {
                if ( lottos[i] == 0 )  {
                    zero++;
                    break;
                }
                else if ( lottos[i] == win_nums[j] ) {
                    matched++;
                    break;
                }
            }
        }
        //System.out.println(matched);
        //System.out.println(zero);
        // 1등이 다 맞춘것
        // 2등은 1개 틀린 것. - 5개 맞춘것.
        // 3등은 2개 틀린 것. - 4개 맞춘것.
        // 4등은 3개 틀린 것. - 3개 맞춘것.
        // 5등은 4개 틀린 것. - 2개 맞춘것.
        // 순위 = 7 - 맞춘개수.

        answer[0] = matched+zero == 0 ? 6 : 7 - (matched + zero);                   // 최고순위    0까지 맞춘 개수로 취급.
        answer[1] = matched == 0 ? 6 : 7 - matched;                                 // 최저순위
        return answer;
    }
}
