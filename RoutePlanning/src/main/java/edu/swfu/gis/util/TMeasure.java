package edu.swfu.gis.util;

import edu.swfu.gis.entity.TPoint;

public class TMeasure {
	/**
	 * Gets the distance.
	 * 
	 * @param lonlat1 the lonlat1
	 * @param lonlat2 the lonlat2
	 * 
	 * @return the distance
	 */
	public static double getDistance(TPoint lonlat1,TPoint lonlat2){
		double a = rad(lonlat1.getY()) - rad(lonlat2.getY());
		double b = rad(lonlat1.getX()) - rad(lonlat2.getX());
		
		double distance = 2*Math.asin(Math.sqrt(Math.pow(Math.sin(a/2), 2)+Math.cos(rad(lonlat1.getY()))*Math.cos(rad(lonlat2.getY()))*Math.pow(Math.sin(b/2), 2)));
		distance = distance * 6378.137;//earth_radius
		//distance = Math.round(distance * 10000)/10000;
		
		return distance;
	}
	
	/**
	 * Rad.
	 * 
	 * @param d the d
	 * 
	 * @return the double
	 */
	public static double rad(double d){
		return d * Math.PI / 180.0;
	}
}
