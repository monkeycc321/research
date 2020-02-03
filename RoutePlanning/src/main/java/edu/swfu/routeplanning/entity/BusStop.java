package edu.swfu.routeplanning.entity;

import edu.swfu.gis.entity.TFeature;

@SuppressWarnings("serial")
public class BusStop  extends TFeature {
	protected String code;
	protected String alias;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
