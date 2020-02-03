package edu.swfu.routeplanning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.gis.service.TFeatureServiceImpl;
import edu.swfu.routeplanning.dao.IBusRoutePointDao;
import edu.swfu.routeplanning.entity.BusRoutePoint;

@Service
public class BusRoutePointServiceImpl extends TFeatureServiceImpl<BusRoutePoint> implements IBusRoutePointService {
	@Autowired
	private IBusRoutePointDao dao;


	@Override
	public IFeatureDao<BusRoutePoint> getDao() {
		return this.dao;
	}

}
