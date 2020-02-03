package edu.swfu.gis.entity;

import java.util.ArrayList;
import java.util.List;


public class TMultiLine extends TGeometry {
	private List<TLine> lines = new ArrayList<TLine>();
	  
	public TMultiLine(int srs, int dim, Object[] coordinates) {
		for (Object obj : coordinates) {
			double[] coords = (double[]) (obj);
			TLine line=new TLine(srs, dim,coords);
			lines.add(line);
		}
	}

	public List<TLine> getLineList() {
		return lines;
	}
	
	public void AddLine(TLine line)
	{
		lines.add(line);
	}

	public int getLineNum() {
		return this.lines.size();	
	}

	public double[][] toCoordinates() 
	{
		double[][] coordinates=null;
		coordinates=new double[this.lines.size()][];
		
		int i=0;
		for (TLine line:this.lines)
		{
			coordinates[i++]=line.toCoordinates()[0];			
		}
		
		return coordinates;
	}

}
