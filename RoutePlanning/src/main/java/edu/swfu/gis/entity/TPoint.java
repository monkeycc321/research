package edu.swfu.gis.entity;

public class TPoint extends TGeometry  {
	private double x;
	private double y;
	private double z;

	
	public TPoint(int srs, int dim, double[] coordinates) {
		this.setSrs(srs);
		this.setDim(dim);
		
		this.x = coordinates[0];
		
		if(dim>1)
			this.y = coordinates[1];
				
		if(dim>2)
			this.z = coordinates[2];
				
	}
	
	public TPoint(int srs,double x,double y){
		this.setSrs(srs);
		this.setDim(2);
		this.setX(x);
		this.setY(y);
	}
	
	public TPoint(double x,double y){
		this(4326,x,y);		
	}
	
	public TPoint(int srs, double x,double y, double z){
		this.setSrs(srs);
		this.setDim(3);
		this.setX(x);
		this.setY(y);
	    this.setZ(z);	
	}
	
	public TPoint(double x,double y,double z){
		this(4326,x,y,z);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public double[][] toCoordinates() {
		double[][] coordinates=null;
		 coordinates=new double[1][this.dim];
		
	    if (this.dim>0)
	    	coordinates[0][0]=this.x;
	    
	    if (this.dim>1)
	    	coordinates[0][1]=this.y;
	    
	    if (this.dim>2)
	    	coordinates[0][2]=this.z;
		
		return coordinates;
	}	
	
}
