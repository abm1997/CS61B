public class warlus{
	public double weight ;
	public double length ;
	public warlus(double w , double l){
		weight = w;
		length = l;
	}

	public static void main(String[] args){
		warlus a = new warlus(1000,8.3);
		warlus b;
		b = a;
		b.weight = 5;
		System.out.println(a.weight);
		System.out.println(b.weight);
	}
}