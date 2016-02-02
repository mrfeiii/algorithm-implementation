package sort;

public class mergeSort {
	
	public static void mergeSort(int[] data){
		int[] temp = new int[data.length];
		internalMergeSort(data,temp,0,data.length - 1);
	}
	
	private static void internalMergeSort(int[] data,int[] temp,int left,int right){
		if(left<right){
			int middle = (left + right) / 2;
			internalMergeSort(data,temp,left,middle);
			internalMergeSort(data,temp,middle+1,right);
			mergeSortedArray(data,temp,left,middle,right);
		}
	}
	
	private static void mergeSortedArray(int[] data,int[] temp,int left,int middle,int right){
		int leftIndex = left;
		int rightIndex = middle + 1;
		int resultIndex = 0;
		
		while(leftIndex <= middle && rightIndex <= right){
			if(data[leftIndex] < data[rightIndex]){
				temp[resultIndex++] = data[leftIndex++];
			}else{
				temp[resultIndex++] = data[rightIndex++];
			}
		}
		
		while(leftIndex<= middle){
			temp[resultIndex++] = data[leftIndex++];
		}
		
		while(rightIndex <= right){
			temp[resultIndex++] = data[rightIndex++];
		}
		
		for(int i = 0 ; i< resultIndex ; i++){
			data[left+i] = temp[i];
		}
		
	}

	public static void bottomUpMergeSort(int[] data,int n){
		int [] temp = new int[n];
		for(int subsetSize = 1; subsetSize < n; subsetSize *=2 ){
			for(int low = 0; low < n-subsetSize; low = low + 2*subsetSize){
				mergeSortedArray(data,temp,low,low+subsetSize-1,Math.min(low+subsetSize*2-1,n-1) );
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,4,6,8,12,43,22,44,16,9};
		bottomUpMergeSort(test,test.length);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
