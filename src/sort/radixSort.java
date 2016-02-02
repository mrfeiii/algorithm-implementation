package sort;

import java.util.ArrayList;
import java.util.List;

public class radixSort {
	
	public static int digit(int number,int d){
		if(d==0){
			return number%10;
		}else{
			return digit(number/10,d-1);
		}
	}

	public static void radixSort(int[] data){
		int RADIX = 10;
		List<Integer>[] bucket = new ArrayList[RADIX];
		for(int i = 0; i < RADIX; i ++){
			bucket[i] = new ArrayList();
		}
		
		boolean Maxlength = false;
		int bucketLocation = -1;
		int placement = 0;
		while(!Maxlength){
			Maxlength = true;
			for(int i : data){
				bucketLocation = digit(i, placement);
				//System.out.println(bucketLocation);
				bucket[bucketLocation].add(i);
				if(bucketLocation>0){
					Maxlength = false;
				}
			}
			int a = 0;
			for(int i = 0; i < RADIX ; i++ ){
				for(int value:bucket[i]){
					data[a++] = value;
				}
				bucket[i].clear();
			}
			placement++;
		}
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,3,6,8,12,43,22,44,16,9};
		radixSort(test);
		for(int i = 0 ; i < test.length ; i++){
		System.out.print(test[i]+" ");
		}
	}

}
