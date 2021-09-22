public class ProAlgoPract_약수의개수와덧셈 {
    public static void main(String[] args) {
        int result = solution(13,17);
        System.out.println("실행결과 : " + result);
    }
    public static int solution ( int left, int right )  {

        int count = 0;
        int sum = 0;
        for ( int i = left; i <= right; i++ ) {
            for ( int j = 1; j <= i; j++ ) {
                if ( i % j == 0 )
                    count++;
            }
            if( count % 2 == 0 ) {
                // 약수의 개수가 짝수이면.
                sum += i;
                System.out.println("+"+i);
            }
            else {
                sum -= i;
                System.out.println("-"+i);
            }
            count = 0;
        }

        return sum;
    }
}
