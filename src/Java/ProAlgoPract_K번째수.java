package Java;

import java.util.Arrays;

public class ProAlgoPract_K번째수 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Zbcdefg");
        sb.reverse();
        sb.toString();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };
        int[] result = solution(array,commands);

        System.out.println( Arrays.toString(result) );
    }
    public static int[] solution ( int[] array, int[][] commands ) {

        int[] answer = new int[ commands.length ];

        int start=0;
        int end = 0;
        int k=0;

        int [] sliced;

        for ( int i = 0; i < commands.length; i++ ) {

            start = commands[i][0] - 1;
            end = commands[i][1] - 1;
            k = commands[i][2] - 1;

            sliced = new int[ end - start + 1 ];
            int x = 0;
            // start, end, k
            // System.out.println(start+" "+end+" "+k);
            for ( int idx = start; idx <= end; idx++ ) {
                sliced[x++] = array[idx];
            }
            Arrays.sort( sliced );
            answer[i] = sliced[k];
        }

        return answer;
    }
}
