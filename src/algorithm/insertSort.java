package algorithm;

public class insertSort {
	
	public static void insertSort(int[] data,int n){
		int sorted = 1;
		int index;
		while(sorted < n){
			int temp = data[sorted];
			for(index = sorted;index>0;index--){
				if( temp < data[index-1]){
					data[index] = data[index-1];
				}else{
					break;
				}
			}
			data[index] = temp;
			sorted ++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,3,6,8,12,43,22,44,16,9};
		insertSort(test,test.length);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
