package edu.swfu.routeplanning.entity;

import java.util.ArrayList;
import java.util.List;
import edu.swfu.gis.entity.TPoint;

public class PlanningRoute {
	private TPoint origin; 
	private TPoint destination;
	private Double searchRadius;
	private List<DirectRoute> directRoutes=new ArrayList<DirectRoute>();
	
	public TPoint getOrigin() {
		return origin;
	}

	public void setOrigin(TPoint origin) {
		this.origin = origin;
	}

	public TPoint getDestination() {
		return destination;
	}

	public void setDestination(TPoint destination) {
		this.destination = destination;
	}

	public Double getSearchRadius() {
		return searchRadius;
	}

	public void setSearchRadius(Double searchRadius) {
		this.searchRadius = searchRadius;
	}



	public List<DirectRoute> getDirectRoutes() {
		return directRoutes;
	}

	public void setDirectRoutes(List<DirectRoute> directRoutes) {
		this.directRoutes = directRoutes;
	}
}
