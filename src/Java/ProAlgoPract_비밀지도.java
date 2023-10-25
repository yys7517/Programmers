package Java;

import java.util.Arrays;
import java.util.HashMap;

public class ProAlgoPract_비밀지도 {
    public static void main(String[] args) {
        // 카카오 공채 1차 코테 문제 1번.
        // 비밀지도
        int n = 5;
        int[] arr1 = { 9,20,28,18,11 };
        int[] arr2 = { 30,1,21,17,28 };

        String[] result = solution( n, arr1, arr2 );

        System.out.println(Arrays.toString(result) );
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // 반환 배열

        Arrays.fill(answer,"");
        // 기본값인 null 값 대신 빈 값으로 삽입..

        // 1번 지도 배열
        // 초기값을 공백으로 삽입.
        // 공백으로 삽입하는 이유. 이진수 처리 과정 중 처리가 안되는 값은 이진수 0을 의미 "공백"
        // 처리가되는 값은 이진수 1을 의미 "#"
        String[][] a1 = new String[ n ][ n ];
        for (String[] a : a1) {
            Arrays.fill(a," ");
        }

        // 2번 지도 배열
        // 초기값을 공백으로 삽입.
        // 공백으로 삽입하는 이유. 이진수 처리 과정 중 처리가 안되는 값은 이진수 0을 의미 "공백"
        // 처리가되는 값은 이진수 1을 의미 "#"
        String[][] a2 = new String[ n ][ n ];
        for (String[] a : a2) {
            Arrays.fill(a," ");
        }

        // 결과 지도
        String[][] result = new String[ n ][ n ];

        // int 키 값에 따른, String value 해쉬 맵
        HashMap<Integer,String> value = new HashMap<Integer, String>();
        value.put(1,"#");
        value.put(0," ");

//        System.out.println("a1 배열 ");

        // *** 이진수 처리과정 ***
        for( int i = 0 ; i < arr1.length; i++ ) {
            int mok = 0;
            int rest = 0;
            int j = 0;
            do {
                mok = arr1[i] / 2;
                rest = arr1[i] % 2;
                if ( value.containsKey(rest) )
                    a1[i][n-1-j] = value.get(rest);
                arr1[i] = mok;
                j++;
            }while( mok != 0 );
        }

//        // 2차원 배열 출력문.
//        // 배열 초기값 으로 되어있으면 이진수 0으로 취급, 공백 삽입.
//        for (int i = 0; i < a1.length; i++) {
//            for (int j = 0; j < a1[i].length; j++) {
//                if( a1[i][j].equals("") )
//                    a1[i][j] =" ";
////                System.out.printf("[%s] ", a1[i][j]);
//            }
////            System.out.println();
//        }
////        System.out.println();
////        System.out.println("a2 배열 ");


        for( int i = 0 ; i < arr2.length; i++ ) {
            int mok = 0;
            int rest = 0;
            int j = 0;
            do {
                mok = arr2[i] / 2;
                rest = arr2[i] % 2;
                if ( value.containsKey(rest) )
                    a2[i][n-1-j] = value.get(rest);
                arr2[i] = mok;
                j++;
            }while( mok != 0 );
        }

//        // 2차원 배열 출력문.
//        // 배열 초기값 으로 되어있으면 이진수 0으로 취급, 공백 삽입.
//        for (int i = 0; i < a2.length; i++) {
//            for (int j = 0; j < a2[i].length; j++) {
//                if( a2[i][j].equals("") )
//                    a2[i][j] =" ";
////                System.out.printf("[%s] ", a2[i][j]);
//            }
////            System.out.println();
//        }




        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = a1[i][j].equals(" ") && a2[i][j].equals(" ") ? " " : "#";
                answer[i] += result[i][j];
            }
        }
//        System.out.println();
//        System.out.println("결과 배열");
         // 2차원 배열 출력문.
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                System.out.printf("[%s] ", result[i][j]);
//            }
//            System.out.println();
//        }


        return answer;
    }
}
