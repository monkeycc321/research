package edu.swfu.routeplanning.entity;

import edu.swfu.gis.entity.TFeature;

@SuppressWarnings("serial")
public class DirectRoute extends TFeature{
	private Integer rn;
	private Integer distance;
	private Integer stopSn1;
	private BusStop stop1;
	private Integer StopSn2;
	private BusStop stop2;

	public Integer getRn() {
		return rn;
	}	
	
	public void setRn(Integer rn) {
		this.rn = rn;
	}
	
	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getStopSn1() {
		return stopSn1;
	}

	public void setStopSn1(Integer stopSn1) {
		this.stopSn1 = stopSn1;
	}

	public BusStop getStop1() {
		return stop1;
	}

	public void setStop1(BusStop stop1) {
		this.stop1 = stop1;
	}

	public Integer getStopSn2() {
		return StopSn2;
	}

	public void setStopSn2(Integer stopSn2) {
		StopSn2 = stopSn2;
	}

	public BusStop getStop2() {
		return stop2;
	}

	public void setStop2(BusStop stop2) {
		this.stop2 = stop2;
	}
	
	

//	public String getDescribe() {
//		return this.getName()+" ("+this.getId()+") ,"+this.getBusStopSn1()+"-"+this.getBusStopSn2()
//				+":"+this.getBusStopId1()+this.getBusStopName1()+"-"+this.getBusStopId2()+this.getBusStopName2();
//	}
//	
}
