import java.util.Arrays;

public class ProAlgoPract_폰켓몬 {

	public static void main(String[] args) {
		
		int [] nums ={ 3,3,3,2,2,2 };
		int answer = solution (nums);
		System.out.println( answer );

	}
public static int solution(int[] nums) {
		
		int count;
        
        int [] solve = new int [ nums.length / 2 ];
        
        // 왜 이거 안쓰면 틀리지 ?
        Arrays.sort(nums);
        
        solve[0] = nums[0];
        // System.out.println(solve[0]);
        
        int temp = nums[0];
        solve[0] = nums[0];
        
        int j = 1;
        for ( int i = 1; i < nums.length; i++ ) {
        	
        	if ( temp != nums[i] ) {
        		
        		if ( j >= solve.length ) 
        			break;
        		else {
        			solve[ j++ ] = nums[i];
            		temp = nums[i];
        		}
        		
        	}
        }
        // System.out.println(Arrays.toString(solve));
        
        
        int temp1 = solve[0];
        count = 1;
        for ( int k = 1 ; k < solve.length; k++) {
        	if ( temp1 != solve[k] && solve[k] != 0) {
        		count++;
        	}
        }
        
        return count;
    }

}
