

public class ttt {
	
	
	public static int decimal2AnyDecimal(int decimal,int arbitraryHexadecimal){
		final char[] characterSet = new char[]{
			'0','1','2','3','4','5','6','7','8','9',
			'a','b','c','d','e','f','g','h','i','j',
			'k','l','m','n','o','p','q','r','s','t',
			'u','v','w','x','y','z','A','B','C','D',
			'E','F','G','H','I','J','K','L','M','N',
			'O','P','Q','R','S','T','U','V','W','X',
			'Y','Z'
	};
		StringBuilder sb = new StringBuilder();
		int remainder = 0;
		while(decimal > 0){
			remainder = (int)decimal%arbitraryHexadecimal;
			sb.append(characterSet[remainder]);
			decimal/=arbitraryHexadecimal;
		}				
		
			 int ret = Integer.parseInt(sb.reverse().toString());
			 return ret;
	}
	
	public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x>=0 && x<10){
            return true;
        }
        
        int temp = 0;
        int newpart = 0;
        int num = x;
        while( num % 10 != num){
            temp *= 10;
            newpart = num%10;
            temp = temp + newpart;
            num = num / 10;
        }
        temp = temp*10 + num;
        if(temp == x){
            return true;
        }
        return false;
    }
	
	public static int answer(int n) { 
        // Your code goes here.
        for(int i = 2; i <= n; i++){
            int temp = decimal2AnyDecimal(n,i);
            if(isPalindrome(temp)){
                return i;
            }
        }
		return n;

    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(answer());
		
	}
	
	
}
