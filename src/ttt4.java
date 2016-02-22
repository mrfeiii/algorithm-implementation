import java.util.HashMap;
import java.util.LinkedList;

public class ttt4 {

	public static String answer(String document, String[] searchTerms) {
		// Your code goes here.
		HashMap<String, Boolean> terms = new HashMap<String, Boolean>();
		String[] documentWords = document.split(" ");
		LinkedList<Integer> outPutIndex = new LinkedList<Integer>();

		if (documentWords.length < searchTerms.length) {
			return null;
		}

		for (int i = 0; i < searchTerms.length; i++) { // Initialize searchTerms
														// HashTable
			terms.put(searchTerms[i], false);
		}
		int start = 0;
		int length = Integer.MAX_VALUE;

		for (int j = 0; j <= documentWords.length - searchTerms.length; j++) {
			for (int i = j; i < documentWords.length; i++) {
				if (terms.containsKey(documentWords[i])) { // current item is contains in searchTerms

					if (terms.get(documentWords[i]) == false) { // if it is the first time occurrence,change index to current index;
						terms.put(documentWords[i], true);
						outPutIndex.add(i);
					} else { // not the first time, need to update the index.
						if (documentWords[i].equals(documentWords[outPutIndex
								.getFirst()])
								&& outPutIndex.getLast() != outPutIndex
										.getFirst()) {
							if ((i - outPutIndex.get(1)) < (outPutIndex
									.getLast() - outPutIndex.getFirst())) {
								outPutIndex.remove(0);
								outPutIndex.add(i);
							}
						}
					}
				}
			}
			if ( outPutIndex.size() >=searchTerms.length && (outPutIndex.getLast() - outPutIndex.getFirst()) < length) {
				
				start = outPutIndex.getFirst();
				length = outPutIndex.getLast() - outPutIndex.getFirst();
			}
			outPutIndex.clear();
			for (int i = 0; i < searchTerms.length; i++) { // reset searchTerms HashTable
				terms.put(searchTerms[i], false);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= start + length - 1; i++) {
			sb.append(documentWords[i] + " ");
		}
		sb.append(documentWords[start + length]);
		return sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "a d a v c a b d c";
		String[] t = { "a", "c", "d" };
		System.out.println(answer(s, t));
	}

}
