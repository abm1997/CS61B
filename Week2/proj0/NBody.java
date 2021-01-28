public class NBody{
	public static double readRadius(String filePath){
		In in = new In(filePath);
		in.readInt(); //skipping the first line which is the number of bodys 
		return in.readDouble();
	}

	public static Body[] readBodies(String filePath){
		In in = new In(filePath);
		int arraylength = in.readInt(); 
		in.readDouble(); //skipping the seconde line which is the radius of universe
		Body[] bodies = new Body[arraylength];
		for(int i=0 ; i<arraylength ; i++){
			bodies[i] = new Body(in.readDouble(),in.readDouble()
				,in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}
		return bodies;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Double radiusUniv = NBody.readRadius(filename);
		Body[] theBodys = NBody.readBodies(filename);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-1*radiusUniv,radiusUniv);
		StdDraw.clear();
		StdDraw.picture(0,0,"./images/starfield.jpg");
		StdDraw.show();
	}
}