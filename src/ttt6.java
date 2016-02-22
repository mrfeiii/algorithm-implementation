
public class ttt6 {
	
//	public static int answer(int[] heights) { 
//		int countZeros = 0;
//		boolean isBoundZero = true; 
//		boolean allZeros = false;
//		int countNotZero = 0;
//		while( allZeros == false ){
//			countNotZero = 0;
//			int tempCount = 0;
//			for(int i = 0;i<heights.length;i++){
//				
//				if( heights[i] != 0 && isBoundZero == true){
//					isBoundZero = false;
//					heights[i] -= 1;
//					countNotZero++;
//				}else if ( heights[i] != 0 && isBoundZero == false){
//					countZeros += tempCount;
//					tempCount = 0;
//					heights[i] -= 1;s
//					countNotZero++;
//				}else if( heights[i] == 0 && isBoundZero == false ){
//					tempCount++;
//				}
//			}
//			if(isBoundZero == true || countNotZero <= 1){
//				allZeros = true;
//			}
//			
//			isBoundZero = true;
//			
//		}
//		
//		return countZeros;
//
//    } 
	
	public static int answer(int[] heights) {
		int rains = 0;
		int[] leftMax = new int[heights.length];
		int[] rightMax = new int[heights.length];
		int leftTempMax = 0;
		int rightTempMax = 0;
		for(int i = 0 ; i < heights.length ; i++ ){
			if(leftTempMax < heights[i]){
				leftMax[i] = heights[i];
				leftTempMax = heights[i];
			}else{
				leftMax[i] = leftTempMax;
			}
		}
		
		for(int i = heights.length-1 ; i >= 0 ; i--){
			if(rightTempMax < heights[i]){
				rightMax[i] = heights[i];
				rightTempMax = heights[i];
			}else{
				rightMax[i] = rightTempMax;
			}
		}
		
		for(int i = 0 ; i < heights.length ; i++){
			if(Math.min(leftMax[i], rightMax[i])>heights[i]){
				rains += Math.min(leftMax[i], rightMax[i]) - heights[i];
			}
		}
		
		return rains;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {1,4,2,5,1,2,3};
		System.out.println(answer(t));
	}

}
