public class ProAlgoPract_예산 {
    public static void main(String[] args) {
        int[] d = { 2,2,3,3 };
        int budget = 10;

        int result = solution( d,budget );
        System.out.println("실행 결과 : " + result);

    }
    public static int solution(int[] d, int budget) {
        int count = 0;

        for ( int i = 0 ; i < d.length; i++ ) {
            while ( true ) {
                budget -= d[i];

                if ( budget < 0 )
                    break;

                count ++;
                break;
            }
        }
        return count;
    }
}
