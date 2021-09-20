import java.util.*;

public class ProAlgoPract_완주하지못한선수 {

	public static void main(String[] args) {
		int participnum;
		Scanner sc = new Scanner(System.in);
		System.out.println("> 참가자 수 ?");
		participnum = sc.nextInt();
		
		String [] participant = new String [participnum];		//참가자 배열
		String [] completion = new String [ participant.length - 1 ];	// 완주자 배열
		
		System.out.println("> 참가자 명단 ?");
		for ( int i = 0; i < participant.length; i++ ) {
			participant[i] = sc.next();
		}
		
		System.out.println("> 완주자 명단 ?");
		for ( int i = 0; i < completion.length; i++ ) {
			completion[i] = sc.next();
		}
		
		String answer = solution ( participant, completion );
		
		System.out.println("> 미 완주자 : " +answer);
		
	}
	
	public static String solution( String[] participant, String[] completion ) {
        String answer = "";

        // 성능 때문이 아니라
		// 오름차순 정렬을 하면
		// 알파벳순  a~z

		// paritipant = eden kiki leo
		// completion = eden kiki ---

		// f j m n v
		// f j m n --

		// ana mislav mislav stanko
		// ana mislav stanko

        Arrays.sort(participant);
        Arrays.sort(completion);


        for( int i = 0; i < completion.length; i++) {
            if ( ! participant[i].equals(completion[i]) ) {
                answer += participant[i];
                return answer;
                // 반환을 하면서 함수가 종료됨.
            }
        }

        answer += participant[ participant.length -1 ];
        return answer;
    }

}
