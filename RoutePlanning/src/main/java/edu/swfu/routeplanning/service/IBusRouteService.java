package edu.swfu.routeplanning.service;
import java.util.List;

import edu.swfu.gis.service.IFeatureService;
import edu.swfu.routeplanning.entity.BusRoute;
import edu.swfu.routeplanning.entity.BusRoutePoint;
import edu.swfu.routeplanning.entity.BusRouteStop;

public interface IBusRouteService extends IFeatureService<BusRoute> {
	public int insert(BusRoute target,List<BusRouteStop> stops) throws Exception ;

	public int collect(BusRoute target, List<BusRouteStop> stops,
			List<BusRoutePoint> points) throws Exception;
}

