package algorithm;

public class shellSort {
	
	public static void shellSorting(int[] data,int n){
		
		for(int gap = n/2; gap>0; gap = gap/2){
			
			for(int sorted = gap; sorted< n; sorted ++){
				
				for(int temp = sorted-gap; temp>=0 && data[temp]>data[temp+gap];temp -= gap){
				    swap(data,temp,temp+gap);
				    //System.out.println("a");
				}
			    //System.out.println(sorted);
			}
		    //System.out.println("c");
		}
	
	}
	
	private static void swap(int[] data,int a,int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,3,6,8,12,43,22,44,16,9};
		shellSorting(test,test.length);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
