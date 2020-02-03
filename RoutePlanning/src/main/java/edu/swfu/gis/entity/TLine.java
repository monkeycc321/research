package edu.swfu.gis.entity;

import java.util.ArrayList;
import java.util.List;

import edu.swfu.gis.util.TMeasure;

public class TLine extends TGeometry {

	private List<TPoint> points = new ArrayList<TPoint>();

	public TLine(){
		
	};
	
	public TLine(int srs, int dim, List<double[]> coordinates) {
		this(srs,dim,coordinates.get(0));
	}
	
	public TLine(int srs, int dim,double[] coordinates)
	{
		this.setSrs(srs);
		this.setDim(dim);
		
		for (int i=0;i<coordinates.length;)
		{
			double x=coordinates[i++],y=coordinates[i++];

			TPoint point=null;
			
			if (dim==2)
				point=new TPoint(srs,x,y);
			else if (dim==3) 
			{
				double z=coordinates[i++];
				point=new TPoint(srs,x,y,z);
			}
			
			this.addPoint(point);
		}
	}
	
	public TLine( double[] coordinates){
		this(4326, 2, coordinates);
	}
	
	
	public List<TPoint> getpoints() {
		return points;
	}

	public void addPoint(TPoint point){
		points.add(point);
	}
	
	public void addLine(TLine line){
		for (TPoint point:line.points)
		{
			this.addPoint(point);
		}
	}
	public int getPointNum() {
		return this.points.size();	
	}

	public double[][] toCoordinates() {

		double[][] coordinates=null;
		coordinates=new double[1][];
		
		coordinates[0]=new double[this.points.size()*this.getDim()];
		
		int i=0;
		for (TPoint point:this.points)
		{
			if (this.dim==2)
			{
				coordinates[0][i++]=point.getX();
				coordinates[0][i++]=point.getY();
			}
			else if (this.dim==3)
			{
				coordinates[0][i++]=point.getX();
				coordinates[0][i++]=point.getY();
				coordinates[0][i++]=point.getZ();
			}
			else if (this.dim==1)
			{
				coordinates[0][i++]=point.getX();
			}
		}
		
		return coordinates;
	}
	
	public double getDistance(){
		double distance=0;
		
		if (this.getPointNum()>0)
		{
			TPoint point1=this.getpoints().get(0), point2=null;
			for (int i=1;i<this.getPointNum();i++)
			{
				point2=this.getpoints().get(i);
				distance+=TMeasure.getDistance(point1, point2);
								
				point1=point2;
			}
		}
		
		return distance;
	}
	
}
