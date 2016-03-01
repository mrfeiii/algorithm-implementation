
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] t = new boolean[2];
		char c = '3';
		Character.isLetter(c);
		System.out.println(t[1]);
	}

	public static int reverse(int x) {
        int ret = 0;
        int orig = Math.abs(x);
        for(int i = 0 ; i < 32 ; i++){
           
            ret = ret | (orig & 1);
             
            if(i<31){ret = ret << 1;
            orig = orig >> 1;}
        }
        if( x < 0 ){
            ret = (~ret) + 1;
        }
        
        // if( (x>0 && ret < 0) || (x<0 && ret>0) ){
        //     return 0;
        // }
        
        return ret;
        
    }

}
