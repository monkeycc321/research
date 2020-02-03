package edu.swfu.routeplanning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.gis.service.TFeatureServiceImpl;
import edu.swfu.routeplanning.dao.IBusRouteStopDao;
import edu.swfu.routeplanning.entity.BusRouteStop;


@Service
public class BusRouteStopServiceImpl extends TFeatureServiceImpl<BusRouteStop> implements IBusRouteStopService {
	@Autowired
	private IBusRouteStopDao dao;
	
	@Override
	public IFeatureDao<BusRouteStop> getDao() {
		return this.dao;
	}
}
