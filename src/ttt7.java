import java.util.ArrayList;


public class ttt7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( answer(3,2) );
	}
	public static String answer(int N, int K) { 

        // Your code goes here.
        StringBuilder sb = new StringBuilder();
        sb.append(numberOfedges(N,K));
        return sb.toString();
    } 
	public static int combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		if (n <= 0 || n < k)
			return result.size();
	 
		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 1, item, result); // because it need to begin from 1
	 
		return result.size();
	}
	 
	private static void dfs(int n, int k, int start, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
	 
		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}
	
	public static int numberOfedges(int n, int k){
		
		    int t = combine(n,2);
		    int ret = combine(t,k);
		    if (k < combine(n - 1,2) + 1){
		        for( int i=1 ; i<n ; i++){
		            int ni = combine(n - 1, i - 1) ;
		            int x = combine(i,2);
		            for (int j = i - 1; j< Math.min(x,k) + 1 ; j++){
		                ret -= ni * combine(combine(n - i,2),k - j) * numberOfedges(i, j) ;
		            }
		        }
		    }      
		    //String r = ret+"";
		    return ret;
	}

}
