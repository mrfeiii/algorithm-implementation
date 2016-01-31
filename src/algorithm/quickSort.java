package algorithm;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,3,6,8,12,43,22,44,16,9};
		quickSort(test,0,test.length-1);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
