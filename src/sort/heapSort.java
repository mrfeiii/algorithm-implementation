package sort;

public class heapSort {
	/* index start from 0, left child is 2*i + 1,right child is 2*i + 2 
	 * max heap */
	public static void heapSortImpelent(int[] data){
		int N;
		N =  data.length-1;
		createHeap(data,N);
		sort(data,N);
	}
	
	public static void createHeap(int[] data, int n){
		for(int i = n/2; i >= 0; i--){
			heapifyDown(data,n,i);
		}
	}
	
	public static void heapifyDown(int[] data,int n,int i){
		int j = 2 * i + 1;
		int temp = data[i];
		while( j <= n ){
			if(j+1 <= n && data[j] < data[j+1] ){
				j++;
			}
			
			if (temp < data[j] ){
				data[i] = data[j];
				i = j;
				j = 2 * i + 1;
			}else{
				break;
			}
		}
		//System.out.println(j);
		data[i] = temp;
	}
	
	public static void sort(int[] data, int n){
		for(int i = n; i >= 0; i-- ){
			int temp = data[0];
			data[0] = data[i];
			data [i] = temp;
			
			heapifyDown(data,i-1,0); //!!!
		}
	}
	
	
	public static void main(String[] args) {
		int[] test = {4,3,6,8,12,43,22,44,16,9};
		heapSortImpelent(test);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
