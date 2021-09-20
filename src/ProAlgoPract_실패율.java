import java.util.Arrays;

public class ProAlgoPract_실패율 {

   public static void main(String[] args) {
      
      int N = 4;      // 스테이지 수
      
      int [] stages = { 4,4,4,4,4 };
      
      int [] result = new int [ N ];
   
      // stages.length == 사용자 수.
      // result.length == 스테이지 수
      
      //  사용자들이 위치한 스테이지 정보
      //    stages[ i ] -> 1명의 유저가 도달한 스테이지 값.
      
      //System.out.println(Arrays.toString(stages));
      
      result = solution( N, stages );
      
      System.out.println("실행결과 : " + Arrays.toString(result) );
      
   }

   public static int[] solution(int N, int[] stages) {
      
      
      int [] answer = new int [ N ] ; 
      
      double [][] solve = new double [ N+1 ][3];
   
      // solve [0]은 버려 ~
      
      // solve [1][0]      solve[1][1]      solve[1][2]
      //    막힌 사용자      도달한 사용자    1 스테이지
      
      // solve [2][0]      solve[2][1]      solve[2][2]
      //    막힌 사용자      도달한 사용자    2 스테이지
      
      //   ..........................................
      //   ..........................................
      
      // solve [N][0]      solve[N][1]      solve[N][2]
      //    막힌 사용자      도달한 사용자    N 스테이지
      
      
      //    stages[i]의 값은 그 값의 스테이지에서 막힌 사용자를 의미.
      //   그 스테이지에 도달한 사용자도 될 수 있지만,
      //   stages[i]의 값이 더 큰 사용자도 그 스테이지에 도달했었음.
      
      // 해당 스테이지 실패율 = 해당 스테이지 막힌 사용자 수 / 해당 스테이지 도달 사용자 수
      
      //   스테이지에 막힌 사용자 수 증가.
      for ( int i = 0 ; i < stages.length; i++ ) {
         // N 
         if ( stages[i] > N )      //  N번 스테이지까지의 실패율을 구하는 것이므로, 
            continue;            //   더 큰 스테이지의 막힌 사용자 수는 구할 필요 없음
      
         // stages[i]의 값이 stage보다 같거나 높으면 도달한 사용자 수 증가
         // 같을 때는 막힌 사용자 수도 같이 증가.
         
         //stages [i] = 2
         else 
            solve[ stages[i] ][0]++;
         
      }
      
      solve[1][1] = stages.length;   // 1스테이지 도달한 사용자 수 == 사용자 수 ( 초기값 )
      
      // 스테이지 값 주입.
      
      for ( int i = 1; i <= N; i++) {
         solve[i][2] = i;
      }
      
      
      
      // 도달한 사용자 수 구하는 과정.
      for ( int i = 2; i < solve.length; i++ ) {
         solve[i][1] = solve[i-1][1] - solve[i-1][0];
      }
      
      
      double [] failarr = new double [ N+1 ]; // 실패율 값 저장하는 곳.
      
      // 0 ~ N번 인덱스.
      // 0번 인덱스는 그냥 제외.
      // 1~N 스테이지
      // 1번 인덱스는 1 스테이지 실패율 저장.
      // 2번 인덱스는 2 스테이지 실패율 저장.
      // 3번 인덱스는 3 스테이지 실패율 저장.
      // ................
      // N번 인덱스는 N 스테이지 실패율 저장.
      
      //   1 스테이지의 실패율
      //    1 스테이지 막힌 사람 수 / 1 스테이지 도달 사람 수
      
      failarr[1] = solve[1][0] / solve[1][1];         
      
      for ( int i = 1; i < failarr.length; i++ ) {
         // **** 중요 ****
         // 도달한 사람 수가 0이면 실패율이 0이다.
         if ( solve[i][1] == 0 ) {
            failarr[i] = 0;
            continue;
         }
         
         // 실패율 = 막힌 사람 수 / 도달한 사람 수
         failarr[i] = solve[i][0] / solve[i][1];
      }
      
      System.out.println( "스테이지에 따른 실패율 배열 : " + Arrays.toString( failarr ) );

      int max_index = 1;
      
      // 최종 리턴할 배열
      for ( int k = 0 ; k < answer.length; k++) {
         
         for ( int i = 2; i < failarr.length; i++ ) {
         
               if ( failarr[max_index] < failarr[i] ) {
                  max_index = i;
               }   
               else if ( failarr[max_index] == failarr[i]) {
                  
               }
         }
         if ( k == answer.length - 1 && failarr [ failarr.length-1 ] == 0 ) {
            max_index = failarr.length-1;
         }
      
         
         // 최대값 찾아서 그 값이 아닌 인덱스 값을 가져와야 함. 
         answer[k] = max_index;
         failarr[max_index] = -1;
         System.out.println(  "스테이지에 따른 실패율 배열 : " + Arrays.toString(failarr));
         max_index = 1;
      }
         
   
      System.out.println( "스테이지 내림차순 배열 : " + Arrays.toString( answer ) );   
      
      return answer;
   }

}