import java.util.LinkedList;


public class ttt2 {

	private static void sortByEndTime(int[][] times, int left, int right) {
		if (left < right) {
			int rightIndex = right;
			int leftIndex = left;
			int[] temp = times[left];
			while (leftIndex < rightIndex) {
				while (leftIndex < rightIndex && temp[1] < times[rightIndex][1]) {
					rightIndex--;
				}
				if (leftIndex < rightIndex) {
					times[leftIndex++] = times[rightIndex];
				}
				while (leftIndex < rightIndex && temp[1] > times[leftIndex][1]) {
					leftIndex++;
				}
				if (leftIndex < rightIndex) {
					times[rightIndex--] = times[leftIndex];
				}
			}
			times[leftIndex] = temp;
			
			sortByEndTime(times,left,leftIndex-1);
			sortByEndTime(times,rightIndex+1,right);
		}

	}
	
	private static int answer(int[][] times){
		sortByEndTime(times,0,times.length-1);
		int k = 0;
		int count = 1;
		for(int i = 0; i< times.length;i++){
			if(times[i][0]>=times[k][1]){
				count++;
				k = i;
			}
		}
		return count;
	}
	 
	public static void main(String[] args) {
	
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.remove(0);
		System.out.println(  l.get(0) );
	
	}

}
