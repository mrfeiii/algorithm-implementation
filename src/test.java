import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = {1,-1,-1,0};
		int a = 0;
		threeSum(in);
		
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList< List<Integer> >();
        if(nums.length<3){
            return ls;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i <= nums.length-3 ; i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            List<Integer> ret = new ArrayList<Integer>();
            ret.add(nums[i]);
            int start = i+1;
            int end = nums.length-1;
            int target = -nums[i];
            while(start < end){
            	System.out.println("target:"+target+" sum:"+nums[start]+"+"+nums[end] );
                if(target > nums[start]+nums[end]){
                    start++;
                }else if( target < nums[start]+nums[end]){
                    end--;
                }else{
                    ret.add(nums[start]);
                    ret.add(nums[end]);
                    break;
                }
            }
            if( ret.size() == 3 ){
                ls.add(ret);
            }
        }
        
        return ls;
    }

}
