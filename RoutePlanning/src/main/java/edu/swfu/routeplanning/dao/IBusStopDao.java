package edu.swfu.routeplanning.dao;

import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.gis.entity.TGeometry;
import edu.swfu.routeplanning.entity.BusStop;

public interface IBusStopDao extends IFeatureDao<BusStop> {

	public String getStopId(String name,TGeometry geometry);
	
	public String getStopCode(TGeometry geometry);

}
