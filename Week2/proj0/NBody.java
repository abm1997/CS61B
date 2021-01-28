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

		//drawing the background
		StdDraw.setScale(-1*radiusUniv,radiusUniv);
		StdDraw.picture(0,0,"./images/starfield.jpg");

		//drawing the planets
		for(int i=0 ; i<theBodys.length ; i++){
			theBodys[i].draw();
		}

		//Creating the animation
		StdDraw.enableDoubleBuffering();
		for(int time=0 ; time<T ; time += dt){
			double[] xForces = new double[theBodys.length];
			double[] yForces = new double[theBodys.length];

			for(int i=0 ; i<theBodys.length ;i++){
				xForces[i] = theBodys[i].calcNetForceExertedByX(theBodys);
				yForces[i] = theBodys[i].calcNetForceExertedByY(theBodys);
			}

			for(int i=0 ; i<theBodys.length ; i++){
				theBodys[i].update(dt,xForces[i],yForces[i]);
			}

			StdDraw.picture(0,0,"./images/starfield.jpg");
			for(int i=0 ; i<theBodys.length ; i++){
				theBodys[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		//printing final positions
		StdOut.printf("%d\n", theBodys.length);
		StdOut.printf("%.2e\n", radiusUniv);
		for (int i = 0; i < theBodys.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
        	        	  theBodys[i].xxPos, theBodys[i].yyPos, theBodys[i].xxVel,
          	 		       theBodys[i].yyVel, theBodys[i].mass, theBodys[i].imgFileName);   
		}

	}
}