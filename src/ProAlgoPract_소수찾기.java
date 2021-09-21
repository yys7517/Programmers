public class ProAlgoPract_소수찾기 {

    public static void main(String[] args) {
        System.out.println( "\n실행결과 총 소수 개수 : " + solution(13) );
    }

    public static int solution(int n) {
        int answer = 0;
        // i = 2 ~ 10
        for ( int i = 2; i <= n; i++) {
            if ( isPrime(i) ) {
                //System.out.println("isPrime("+i+")");
                answer++;
                //System.out.println(i + "는 소수이다 : " + answer);
            }
        }
        return answer;
    }
    public static boolean isPrime ( int x ) {
        if ( x < 2 )
            return false;
        //  0 과 1은 소수가 아니다.
        else if ( x == 2 )
            return true;
        // 2는 소수이다.
        else {
            // for ( int i = 2; i <= Math.sqrt(x); i++ ) {     // 2 3 4 5 6 7 8 9 10 11 12

            for ( int i = 2; i <= Math.sqrt(x); i++ ) {   // Math.sqrt 제곱근 함수 사용
                // 제곱근 함수를 사용하여 제곱근 까지만 검사를 해도 된다. 성능 상.
                if ( x % i == 0 ) {
                    return false;
                    // 2 부터 자기 자신 -1의 수와 나눠가면서 나누어지면 소수가 아님.
                }
            }
            // 반복문을 무사히 끝내면 소수인것임.
            return true;
        }

    }
}
