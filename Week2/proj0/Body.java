public class Body{
	public double xxPos; //Its current x position
	public double yyPos; //Its current y position
	public double xxVel; //Its current velocity in the x direction
	public double yyVel; //Its current velocity in the y direction
	public double mass;  //Its mass
	public String imgFileName; //The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)
	static final double G=6.67e-11;

	public Body(double xP, double yP, double xV,double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}

	public Body(Body b){
		xxPos=b.xxPos;
		yyPos=b.yyPos;
		xxVel=b.xxVel;
		yyVel=b.yyVel;
		mass=b.mass;
		imgFileName=b.imgFileName;
	}

	public double calcDistance(Body d){
		double dx=d.xxPos-this.xxPos;
		double dy=d.yyPos-this.yyPos;
		return Math.sqrt(dx*dx+dy*dy);
	}

	public double calcForceExertedBy(Body d){
		double distance=this.calcDistance(d);
		return G*this.mass*d.mass/(distance*distance);
	}

	public double calcForceExertedByX(Body d){
		double dx=d.xxPos-this.xxPos;
		double distance=this.calcDistance(d);
		double force=this.calcForceExertedBy(d);
		return force*dx/distance;
	}

	public double calcForceExertedByY(Body d){
		double dy=d.yyPos-this.yyPos;
		double distance=this.calcDistance(d);
		double force=this.calcForceExertedBy(d);
		return force*dy/distance;
	}	

	public double calcNetForceExertedByX(Body[] allBodys){
		double netForceX=0.0;
		for (int i=0 ; i<allBodys.length ;i++){
			if(allBodys[i].equals(this)){
				continue;
			}
			netForceX+=this.calcForceExertedByX(allBodys[i]);		
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Body[] allBodys){
		double netForceY=0.0;
		for (int i=0 ; i<allBodys.length ;i++){
			if(allBodys[i].equals(this)){
				continue;
			}
			netForceY+=this.calcForceExertedByY(allBodys[i]);
		}
		return netForceY;
	}

	public void update(double dt,double fX,double fY){
		double aX=fX/this.mass;
		double aY=fY/this.mass;

		this.xxVel += dt*aX;
		this.yyVel += dt*aY;

		this.xxPos += dt*this.xxVel;
		this.yyPos += dt*this.yyVel;
	}

	public void draw(void){
		StdDraw.picture(0,0,"./images/starfield.jpg");
		StdDraw.show();
	}
}