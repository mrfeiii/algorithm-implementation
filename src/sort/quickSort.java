package sort;

public class quickSort {

	public static void quickSort(int[] data, int left, int right) {
		if (left < right) {
			int rightIndex = right;
			int leftIndex = left;
			int temp = data[left];
			while (leftIndex < rightIndex) {
				while (leftIndex < rightIndex && temp < data[rightIndex]) {
					rightIndex--;
				}
				if (leftIndex < rightIndex) {
					data[leftIndex++] = data[rightIndex];
				}
				while (leftIndex < rightIndex && temp > data[leftIndex]) {
					leftIndex++;
				}
				if (leftIndex < rightIndex) {
					data[rightIndex--] = data[leftIndex];
				}
			}
			data[leftIndex] = temp;
			
			quickSort(data,left,leftIndex-1);
			quickSort(data,rightIndex+1,right);
		}

	}
	
	public static void threeWaysQuickSort(int[] data,int low, int high){
		int left = low;
		int right = high;
		int i = low;
		
		if(high <= low) return;
		
		while(i<=right){
			System.out.println("target :" + data[low]);
			System.out.println(i);
			System.out.println(left);
			System.out.println(right);
			System.out.println("--before----");
			for(int ii = 0 ; ii < data.length ; ii++){
				System.out.print(data[ii]+" ");
				}
			System.out.println("");
			System.out.println("--------------------");
			if(data[left] < data[i]){
				swap(data,i,right);
				right--;
			}else if(data[left] > data[i] ){
				swap(data,i,left);
				i++;
				left++;
			}else{
				i++;
			}
			System.out.println("--after----");
			for(int ii = 0 ; ii < data.length ; ii++){
				System.out.print(data[ii]+" ");
				}
			System.out.println("");
			System.out.println("--------------------");
			
		}
		System.out.println("over");
		
		threeWaysQuickSort(data,low,right-1);
		//System.out.println("2");
		threeWaysQuickSort(data,left+1,high);
		
	}
	
	public static void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1,3,6,8,12,43,22,44,16,9};
		threeWaysQuickSort(test,0,test.length-1);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
