package Java;

import java.util.*;

public class ProAlgoPract_직업군추천하기 {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"};
        // System.out.println(Arrays.toString(table));
        String[] languages = { "PYTHON","C++","SQL" };
        int[] preference = { 7,5,5 };
        String result = solution( table,languages,preference );
        System.out.println(result);
    }
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer ="";

        // 개발자의 언어별 선호도.
        HashMap<String,Integer> langPrefer = new HashMap<String,Integer>();

        // PYTHON -> 7
        // C+ -> 5
        // SQL -> 5
        for ( int i = 0; i < languages.length; i++ ) {
            langPrefer.put( languages[i], preference[i] );
        }

        List<String> result = new ArrayList<String>();
        int HIGH_SCORE = 0;


        for ( int i = 0 ; i < table.length; i++ ) {
            // *************************************************************
            StringTokenizer st = new StringTokenizer(table[i], " ");
            String job = st.nextToken();    // 직업
            int sum = 0;                    // 총합
            int point = 5;                  // 점수

            while ( st.hasMoreTokens() ) {
                String language = st.nextToken();
                if ( langPrefer.containsKey(language) ) {
                    sum += ( langPrefer.get(language) * point );
                }
                point--;
            }

            if ( HIGH_SCORE < sum ) {
                HIGH_SCORE = sum;

                answer = job;
                result.clear();
                result.add(job);
            }
            else if ( HIGH_SCORE == sum ){
                result.add( job );
            }
        }

        if ( result.size() > 1 )  // 고득점인 직업이 1개 이상일 때.
        {
            Collections.sort( result );
            answer = result.get(0);
        }

        return answer;
    }
}





// System.out.println( table[0].indexOf(" ") );
//
//        // 직업배열 만들어서 채우기.
//        String[][] solve = new String[ table.length+1 ][ table.length+1 ];
//
//
//        int Score = 5;
//        for( int i = 1; i < solve.length; i++) {
//            solve[0][i] = table[i-1].substring( 0 , table[i-1].indexOf(" ") );
//            solve[i][0] = String.valueOf( Score-- );
//        }
//        for( int i = 0; i < solve.length; i++) {
//            for (int j = 0; j < solve[i].length; j++) {
//                if (solve[i][j] == null) {
//                    System.out.printf("[%s] ", "-");
//                } else {
//                    System.out.printf("[%s] ", solve[i][j]);
//                }
//            }
//            System.out.println();
//        }
////        SI_LANG => SI의 언어.
////        SI_LANG[0] * 5-0; == solve[1][1] * 5-0
////        SI_LANG[1] * 5-1; == solve[2][1] * 5-1
////        SI_LANG[2] * 5-2; == solve[3][1] * 5-2
////        SI_LANG[3] * 5-3; == solve[4][1] * 5-3
////        SI_LANG[4] * 5-4; == solve[5][1] * 5-4
//



