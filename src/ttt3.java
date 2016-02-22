import java.util.HashMap;

public class ttt3 {
	
	public static int answer(String[] x) {
		HashMap<String,String> ht = new HashMap<String,String>();
		int count = 0;
		for(int i = 0 ; i< x.length ; i++){
			if( !ht.containsKey(x[i]) && !ht.containsValue(x[i]) ) {
				ht.put( x[i],new StringBuilder(x[i]).reverse().toString() );
				count++;
			}
		}
	
		return count;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t = {"x", "y", "xy", "yy", "", "yx"};
		System.out.println( answer(t) );
		
	}

}
