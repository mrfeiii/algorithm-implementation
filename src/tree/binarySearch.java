package tree;

public class binarySearch {
	/* binary search for sorted array */

    public static int  binarySearchImplement(int[] data,int item){
    	int head = 0;
    	int tail = data.length-1;
    	int middle = ( head + tail )/2;
    	while(head<=tail){
    		if(item > data[middle] ){
    			head = middle+1;
    		}else if (item < data[middle]){
    			tail = middle-1;
    		}else{
    			return middle;
    		}
    		
    		middle = ( head + tail )/2;
    	}
    	return -1;	
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {2,4,7,9,12,13,17,22,29};
		int p = binarySearchImplement(test,19);
		System.out.println(p);
		
	}

}
