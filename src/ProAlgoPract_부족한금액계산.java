public class ProAlgoPract_부족한금액계산 {
    public static void main(String[] args) {
        int money = 30;
        int price = 3;
        int count = 4;

        long result = solution(price,money,count);
        System.out.println(result);
    }
    public static long solution ( int price, int money, int count ) {
        long answer ;
        long total = 0;
        for ( int i = 1 ; i <= count; i++ ) {
            total += price * i;
        }

        answer = total - money;

        // 돈이 부족하지 않다면 0을 리턴한다.
        // answer은 부족한 돈 값.
        // 음수이면 보유한 money가 많다는 뜻.
        // answer이 음수이면 0을 리턴.

        if ( answer < 0 ) {
            return 0;
        }

        return answer;
    }
}
