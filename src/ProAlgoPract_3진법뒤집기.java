import java.util.*;

public class ProAlgoPract_3진법뒤집기 {

   public static void main(String[] args) {
      
      int a = solution(125);
      System.out.println();
      System.out.println("10진법 = "+a);
   }
   
    public static int solution(int n) {
          int temp = n;
         int count = 1;
         
         while(temp >= 3) {
            temp = temp / 3;
            count++;
         }
          int[] arr = new int[count];
          int[] arrReverse = new int [count];
           
          int i = count;
          int temp1 = n;
          
          
          while (i > 0) {
             arr[i-1] = temp1 % 3;
             temp1 = temp1 / 3;
             i--;
          }
          System.out.println("3진법 : " + Arrays.toString(arr));
     

          i = count;
          
          while( i > 0 ) {
             arrReverse[ count-i ] = n % 3;
             n = n / 3;
             i--;
          }
          
          System.out.println("3진법 반전 : " +Arrays.toString(arrReverse));
          
          
          int answer = 0;
          // j = 0 1 2 3
          // answer += math.pow(3,3) * arrReverse[0]
          // answer += math.pow(3,2) * arrReverse[1]
          // answer += math.pow(3,1) * arrReverse[2]
          // answer += math.pow(3,0) * arrReverse[3]
          
          // j = 0 1 2 3 4
          // answer += math.pow(3,4) * arrReverse[0]
          // answer += math.pow(3,3) * arrReverse[1]
          // answer += math.pow(3,2) * arrReverse[2]
          // answer += math.pow(3,1) * arrReverse[3]
          // answer += math.pow(3,0) * arrReverse[4]
          
          for ( int j = 0; j < count; j++) {
             answer += Math.pow(3, count-j-1) * arrReverse[j];
          }
          
          
           return answer;
       }
}