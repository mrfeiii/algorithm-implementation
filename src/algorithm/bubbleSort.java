package algorithm;

public class bubbleSort {
	
	private static void swap(int[] data,int i,int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public static void bubblSort(int[] data){
		for(int i = 0 ; i<data.length ; i++ ){
			for(int j = i; j<data.length;j++){
				if(data[i] > data [j]){
					swap(data,i,j);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int[] test = {4,3,6,8,12,43,22,44,16,9};
		bubblSort(test);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}
	
}
