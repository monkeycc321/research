package edu.swfu.routeplanning.service;

import java.util.List;

import edu.swfu.gis.entity.TGeometry;
import edu.swfu.gis.service.IFeatureService;
import edu.swfu.routeplanning.entity.BusStop;

public interface IBusStopService  extends IFeatureService<BusStop>{
	public String getStopId(String name,TGeometry geometry);
	public String getStopCode(TGeometry geometry);
	
	public List<BusStop> selectByRoute(String busRouteId) throws Exception;
	public List<BusStop> selectByRoute(String busRouteId,int sn1,int sn2) throws Exception;
}
