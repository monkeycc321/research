package edu.swfu.routeplanning.entity;

import edu.swfu.gis.entity.TFeature;

@SuppressWarnings("serial")
public class BusRouteStop extends TFeature {
	private String BusRouteId;
	private Integer sn;
	private String BusRouteName;
	
	public String getBusRouteId() {
		return BusRouteId;
	}
	public void setBusRouteId(String busRouteId) {
		BusRouteId = busRouteId;
	}
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	public String getBusRouteName() {
		return BusRouteName;
	}
	public void setBusRouteName(String busRouteName) {
		BusRouteName = busRouteName;
	}

}
