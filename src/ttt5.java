
public class ttt5 {
	
	public static int coins(int n){
		int[] padSizes = new int[101];
		int[] track = new int[n+1];
		for(int i = 0 ; i <= 100 ; i++ ){
			padSizes[i] = i * i ;
		}
		track[0] = 0;
		int min ;
		for(int i = 1;i<=n;i++){
			min = Integer.MAX_VALUE;
			for(int j = 1; j <= 100; j++){
				if(padSizes[j] <= i){
					if( (track[i-padSizes[j]]+1) < min){
						min = track[i-padSizes[j]]+1;
					}
				}else{
					break;
				}
			}
			track[i] = min;
		}
		for(int i = 0 ; i<= n ; i++){
			System.out.println("teack "+i+"="+track[i]);
		}
		System.out.println("n "+n);
		return track[n];
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coins(4));
		
	}

}
