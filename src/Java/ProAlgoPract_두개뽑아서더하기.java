package Java;

import java.util.ArrayList;
import java.util.Arrays;

public class ProAlgoPract_두개뽑아서더하기 {
    public static void main(String[] args) {
       int[] numbers =  { 2,1,3,4,1 };
        int[] result = solution( numbers );

        System.out.println( Arrays.toString( result ) );
    }

    public static int[] solution(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        // 0 + 1
        // 0 + 2
        // 0 + 3
        // 0 + 4
        // 1 + 2
        // 1 + 3
        // 1 + 4
        // 2 + 3
        // 2 + 4
        // 3 + 4

        for ( int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = numbers[i] + numbers[j];
                if (list.indexOf(a) < 0)
                    list.add(a);            // indexOf() 는 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환하며
                                            // 만약 찾지 못했을 경우 "-1"을 반환합니다.
            }
        }


        //String[] str = (String[]) list.toArray();
       // 실행시 에러가난다. toArray()는 Object[]형태로 반환되고 String[]으로 형변환이 불가하기 때문이다.
        // 따라서 String형으로 받고자하는 경우는 밑과 같은 방식으로해야한다.

       // String[] str = (String[]) list.toArray( new String[list.size()] );



        int[] answer = new int[ list.size() ] ;
        for ( int i = 0; i < list.size(); i++ ) {
            answer[i] = list.get(i);
        }
        Arrays.sort( answer );
        // System.out.println( Arrays.toString( list.toArray() ));
        return answer;
    }
}

