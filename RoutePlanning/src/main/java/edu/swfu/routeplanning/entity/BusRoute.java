package edu.swfu.routeplanning.entity;

import edu.swfu.gis.entity.TFeature;

@SuppressWarnings("serial")
public class BusRoute extends TFeature {
	public float price;
	public String firstTime;
	public String finalTime;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

	public String getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(String finalTime) {
		this.finalTime = finalTime;
	}
	

}