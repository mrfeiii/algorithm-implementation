package tree;

import java.util.Scanner;

class priorityQueueImplement {

	
	/*******
	 * max binary heap*****
	 * root index is 0, left child index 2*i +1, right child index 2*i + 2
	 * */
	public final int[] pq;
	private final int N;
	private int mysize;

	public priorityQueueImplement(int capacity) {
		N = capacity-1;
		pq = new int[N];
		mysize = 0;
	}

	public void inser(int number) {
		if (mysize == N) {
			System.out.println("queue full");
			return;
		} else {
			pq[++mysize] = number;
			for(int i=0;i<N;i++){
				System.out.print(pq[i]+" ");
			}
			System.out.println(" ");
			heaptifyUp(mysize);
		}
	}
	
	public int remove(){
		int temp = pq[0];
		if(mysize != 0){
		swap(pq,0,mysize--);
		}else{
			return 0;
		}
		
		for(int i=0;i<N;i++){
			System.out.print(pq[i]+" ");
		}
		System.out.println("<---before-------");
		
		heaptifyDown(0);
		
		for(int i=0;i<N;i++){
			System.out.print(pq[i]+" ");
		}
		System.out.println("<---after-------- ");
		return temp;
	}
	
	

	private void heaptifyUp(int n) {
		while (n >= 0 && pq[n] > pq[(n-1) / 2]) {
			swap(pq, n, (n-1) / 2);
			n = (n-1) / 2;
		}
	}

	private void heaptifyDown(int n) {
		int j = 2*n+1;
		int temp = pq[n]; 
		while (j <= mysize) {
			if(j+1 < mysize && pq[j] < pq[j+1] ){
				j++;
			}
			
			if(temp < pq[j]){
				pq[n] = pq[j];
				n = j;
				j = 2*n +1;
			}else{
				break;
			}
		}
		pq[n] = temp;
	}

	private void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	

}

public class priorityQueue {

	/* index start from 0, left child is 2*i + 1,right chile is 2*i + 2 
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
		// TODO Auto-generated method stub
		priorityQueueImplement bh =new priorityQueueImplement(10);
		while(true){
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			if(choice == 1){
				int number = scan.nextInt();
			    bh.inser(number);
			    int[] test = new int[bh.pq.length];
			    System.arraycopy( bh.pq, 0, test, 0, bh.pq.length );
			    for(int i = 0 ; i < test.length ; i++){
					System.out.print(test[i]+" ");
					}
			    System.out.print("--------");
			    heapSortImpelent(test);
			    for(int i = 0 ; i < test.length ; i++){
					System.out.print(test[i]+" ");
					}
			}else if(choice == 2){
				int max = bh.remove();
				System.out.println(max);
			}
		   
		}
		
	}


	

}
