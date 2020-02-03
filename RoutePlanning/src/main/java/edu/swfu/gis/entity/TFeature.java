package edu.swfu.gis.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TFeature implements Serializable {
	protected String id;
	protected String name;
	protected String notes;
	protected TGeometry geometry;

	protected String layerName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TGeometry getGeometry() {
		return geometry;
	}

	public void setGeometry(TGeometry geometry) {
		this.geometry = geometry;
	}
	

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLayerName() {
		return layerName;
	}


	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

}
