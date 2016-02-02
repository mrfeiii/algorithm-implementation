package tree;

import java.util.Scanner;

class priorityQueueImplement {

	
	/*******
	 * max binary heap*****
	 * 
	 * */
	private final int[] pq;
	private final int N;
	private int mysize;

	public priorityQueueImplement(int capacity) {
		N = capacity;
		pq = new int[N+1];
		mysize = 0;
	}

	public void inser(int number) {
		if (mysize == N) {
			System.out.println("queue full");
			return;
		} else {
			pq[++mysize] = number;
			heaptifyUp(mysize);
		}
	}
	
	public int remove(){
		int temp = pq[1];
		swap(pq,1,mysize--);
		heaptifyDown(pq[1]);
		return temp;
	}
	
	

	private void heaptifyUp(int n) {
		while (n > 1 && pq[n] > pq[n / 2]) {
			swap(pq, n, n / 2);
			n = n / 2;
		}
	}

	private void heaptifyDown(int n) {
		int bigger = 2*n;
		while (2 * n <= N) {
			if (2 * n == N) {
				bigger = 2 * n;
			} else if (pq[2 * n] < pq[2 * n + 1]) {
				bigger = 2 * n + 1;
			}
			
			if(pq[n] < pq[bigger] ){
				swap(pq,n,bigger);
				n = bigger;
			}else{
				break;
			}
		}
	}

	private void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	

}

public class priorityQueue {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		priorityQueueImplement bh =new priorityQueueImplement(10);
		while(true){
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			if(choice == 1){
				int number = scan.nextInt();
			    bh.inser(number);
			}else if(choice == 2){
				int max = bh.remove();
				System.out.println(max);
			}
		   
		}
		
	}


	

}
