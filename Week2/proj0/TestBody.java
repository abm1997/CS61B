public class TestBody {
	public static void main(String args[]){
		/**
			small test 
			makes 2 bodys d1 and d2 
			calculate the pairwise force between 
			and compare it with the result of calcForceExertedBy method
		*/
		Body d1 = new Body(10,20,2,3,7,"d1.png");
		Body d2 = new Body(100,200,20,30,77,"d2.png");
		double force = d1.calcForceExertedBy(d2);
		if (force - 8.8768e-13 <= 0.2e-13 || 8.8768e-13 - force <= 0.2e-13 ){
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}
}