package sort;

public class selectSort {
	
	public static void selectSort(int[] data,int n){
		int maxIndex;
		int index;
		int numUnsorted = n;
		while(numUnsorted > 0){
			maxIndex = 0;
			for(index = 1 ; index<numUnsorted ; index++){
				if(data[maxIndex] < data[index]){
					maxIndex = index;
				}
			}
			swap(data,maxIndex,numUnsorted-1);
			numUnsorted--;
		}
		
	}
	private static void swap(int[] data,int maxIndex,int index){
		int temp = data[maxIndex];
		data[maxIndex] = data[index];
		data[index] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,3,6,8,12,43,22,44,16,9};
		selectSort(test,test.length);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
