import java.util.Arrays;

public class ProAlgoPract_상호평가 {
    public static void main(String[] args) {
        int[][] scores = {
                {100,90,98,88,65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}
        };
        /*int[][] scores = {
                {50,90},
                {50,87}
        };*/
        /*int[][] scores = {
                {70,49,90},
                {68,50,38},
                {73,31,100}
        };*/
        String result = solution(scores);
        System.out.println(result);
    }

    public static String solution(int[][] scores) {
        StringBuilder sb =  new StringBuilder();          // 0~4번 학생 학점.
        double[] avg = new double[scores.length];
        int[] max = new int[scores.length];
        int[] min = new int[scores.length];

        // 최대값 , 최소값 구하기 위해서 초기값 채워넣기
        for (int i = 0; i < max.length; i++) {
            max[i] = scores[0][i];
            min[i] = scores[0][i];
        }
        // 최고점 구하기
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                if (max[i] < scores[j][i])
                    max[i] = scores[j][i];


            }
        }
        //System.out.println("최고점 배열 : " + Arrays.toString(max));

        // 최저점 구하기
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                if (min[i] > scores[j][i])
                    min[i] = scores[j][i];

            }
        }
        //System.out.println("최저점 배열 : " + Arrays.toString(min));


        int count = 0;
        // 자신에게 부여한 점수가 최고점이거나 최저점일경우 0으로 할당.
        // ********** 유일한 최고점 또는 유일한 최저점 ********* -> 개수가 1개여야한다.
        for (int i = 0; i < scores.length; i++) {
            count = 0;

            for (int j = 0; j < scores[i].length; j++) {
                if (max[i] == scores[j][i])
                    count++;
            }

            if (scores[i][i] == max[i] && count == 1) {
                scores[i][i] = 0;
            }

            count = 0;

            for (int j = 0; j < scores[i].length; j++) {
                if (min[i] == scores[j][i])
                    count++;
            }

            if (scores[i][i] == min[i] && count == 1) {
                scores[i][i] = 0;
            }


        }

       /* // 2차원 배열 출력문.
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.printf("[%d] ", scores[i][j]);
            }
            System.out.println();
        }*/

        int sum = 0;    // 평균을 구하기 위한 총점
        int zero = 0;   // 0의 개수

        // 평균 구하자.
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[j][i];
                if (scores[j][i] == 0)
                    zero++;
            }
            // System.out.println(sum);
            avg[i] = (double) sum / (scores.length - zero);
            sum = 0;
            zero = 0;
        }
        //System.out.println("평균 배열 : " + Arrays.toString(avg));

        for ( int i = 0; i < avg.length; i++ ) {
            sb.append(avg[i] >= 90? "A" : avg[i] >= 80 ? "B" : avg[i] >= 70 ? "C" : avg[i] >= 50 ? "D" : "F");
        }

        return sb.toString();
    }
}
