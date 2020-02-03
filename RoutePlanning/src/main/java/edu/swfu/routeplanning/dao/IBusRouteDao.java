package edu.swfu.routeplanning.dao;

import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.routeplanning.entity.BusRoute;

public interface IBusRouteDao extends IFeatureDao<BusRoute> {
	public int iniRouteGeo(BusRoute target) throws Exception;
}
