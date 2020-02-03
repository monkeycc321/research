package edu.swfu.gis.entity;

public abstract class TGeometry {
	protected int srs;
	protected int dim=2;
	public TGeometry(){
		
	}
	
	public int getSrs() {
		return srs;
	}
	public void setSrs(int srs) {
		this.srs = srs;
	}
	public int getDim() {
		return dim;
	}
	public void setDim(int dim) {
		this.dim = dim;
	}
	
	public abstract double[][] toCoordinates();

}
