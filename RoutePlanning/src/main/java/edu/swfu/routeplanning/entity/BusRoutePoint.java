package edu.swfu.routeplanning.entity;

import edu.swfu.gis.entity.TFeature;

@SuppressWarnings("serial")
public class BusRoutePoint extends TFeature{
	private String busRouteId;

	public String getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(String busRouteId) {
		this.busRouteId = busRouteId;
	}
}
