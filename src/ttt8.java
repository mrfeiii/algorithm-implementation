public class ttt8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t = { { 6, 6 }, { -3, -4}, { 3, 1 } };
		System.out.println(answer(t));
	}

	public static int answer(int[][] vertices) {

		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = i; j < 3; j++) {
				if (vertices[i][1] < vertices[j][1]) {
					int tempX = vertices[i][0];
					int tempY = vertices[i][1];
					vertices[i][0] = vertices[j][0];
					vertices[i][1] = vertices[j][1];
					vertices[j][0] = tempX;
					vertices[j][1] = tempY;
				}
			}
		}

		for (int i = 0; i < 3; i++) {

			System.out.println(vertices[i][0] + " " + vertices[i][1]);

		}

		int topX = vertices[0][0];
		int topY = vertices[0][1];
		int middleX = vertices[1][0];
		int middleY = vertices[1][1];
		int bottomX = vertices[2][0];
		int bottomY = vertices[2][1];

		double topMiddleK = (topY - middleY) / (double) (topX - middleX);
		double topBottomK = (topY - bottomY) / (double) (topX - bottomX);
		double middleBottomK = (middleY - bottomY)
				/ (double) (middleX - bottomX);

		System.out.println("topMiddleK :" + topMiddleK);
		System.out.println("topBottomK :" + topBottomK);
		System.out.println("middleBottomK :" + middleBottomK);

		double topMiddleB = topY - topMiddleK * topX;
		double topBottomB = topY - topBottomK * topX;
		double middleBottomB = middleY - middleBottomK * middleX;

		System.out.println("topMiddleB :" + topMiddleB);
		System.out.println("topBottomB :" + topBottomB);
		System.out.println("middleBottomB :" + middleBottomB);

		for (int i = topY-1; i > bottomY; i--) {
			if (i >= middleY) {
				double x1 = (i - topMiddleB) / (double) topMiddleK;
				double x2 = (i - topBottomB) / (double) topBottomK;
				System.out.println("x1 :" + x1);
				System.out.println("x2 :" + x2);

				if (Math.ceil(x1) == Math.ceil(x2)
						&& Math.floor(x1) == Math.floor(x2)) {
					  
				} else {
					if (x1 < x2) {

						x1 = Math.ceil(x1) == x1 ? x1+1 : Math.ceil(x1);
						x2 = Math.floor(x2) == x2 ? x2-1 : Math.floor(x2);

					} else {
						x1 = Math.floor(x1) == x1 ? x1-1 : Math.floor(x1);
						x2 = Math.ceil(x2) == x2 ? x2+1 : Math.ceil(x2);;
					}
					count += x2 - x1+1;
					
				}

				System.out.println("xAfter1 :" + x1);
				System.out.println("xAfter2 :" + x2);
				
			} else {
			

				double x1 = (i - topMiddleB) / (double) topMiddleK;
				double x2 = (i - middleBottomB) / (double) middleBottomK;

				System.out.println("xB1 :" + x1);
				System.out.println("xB2 :" + x2);
				
				if (Math.ceil(x1) == Math.ceil(x2)
						&& Math.floor(x1) == Math.floor(x2)) {
					    
				} else {
					if (x1 < x2) {
						x1 = Math.ceil(x1) == x1 ? x1 + 1 : Math.ceil(x1) ;
						x2 = Math.floor(x2) == x2 ? x2 - 1 : Math.floor(x2);
					} else {
						x1 = Math.floor(x1) == x1 ? x1 - 1 : Math.floor(x1);
						x2 = Math.ceil(x2) == x2 ? x2 + 1 : Math.ceil(x2);
					}
					System.out.println("xBAfter1 :" + x1);
					System.out.println("xBAfter2 :" + x2);
					count += x1 - x2 + 1;
				}
				
				
			}
			System.out.println("count"+count);
		}

		return count;
	}

}
