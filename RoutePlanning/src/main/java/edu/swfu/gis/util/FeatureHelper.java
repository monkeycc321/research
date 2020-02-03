package edu.swfu.gis.util;

import java.util.ArrayList;
import java.util.List;

import edu.swfu.gis.entity.TGeometry;
import edu.swfu.gis.entity.TLine;
import edu.swfu.gis.entity.TMultiLine;
import edu.swfu.gis.entity.TPoint;
import oracle.spatial.geometry.JGeometry;

public class FeatureHelper {
	
	private static int srs;


	public static TGeometry  JGeometry2TGeometry(JGeometry para ) {
		TGeometry result=null;
		
		int srs = para.getSRID();
		int dim = para.getDimensions();

		if (para.getType() == 1) {
			double[] coordinates = para.getPoint();
			result = new TPoint(transformJGeometrySRS(srs),dim, coordinates);
		} else if (para.getType() == 2 ) {
			double[] coordinates = para.getOrdinatesArray();
			result = new TLine(transformJGeometrySRS(srs), dim,coordinates);
		} else if (para.getType()==6) {
			Object[] coordinates=para.getOrdinatesOfElements();
			result= new TMultiLine(transformJGeometrySRS(srs), dim,coordinates);
		}
		
		return result;
	}
	
	public static JGeometry  TGeometry2JGeometry(TPoint para ) {
		JGeometry result=new JGeometry(para.getX(),para.getY(),para.getZ(),para.getSrs());
		return result;
	}
	
	public static int transformJGeometrySRS(int srs) {
		return 4326;
	}


	public static int transformDim() {
		return 2;
	}

	public static JGeometry TGeometry2JGeometry(TGeometry para) {
		JGeometry result=null;
		if (para instanceof TPoint) {
			TPoint p=(TPoint)para;
			
			if (p.getDim()==2)
				result=new JGeometry(p.getX(),p.getY(),p.getSrs());
			else if (p.getDim()==3)
				result=new JGeometry(p.getX(),p.getY(),p.getZ(),p.getSrs());
		}
		return result;
	}	

}
