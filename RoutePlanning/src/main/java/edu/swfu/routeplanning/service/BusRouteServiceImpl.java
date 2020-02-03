package edu.swfu.routeplanning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.gis.service.TFeatureServiceImpl;
import edu.swfu.routeplanning.dao.IBusRouteDao;
import edu.swfu.routeplanning.dao.IBusRoutePointDao;
import edu.swfu.routeplanning.dao.IBusRouteStopDao;
import edu.swfu.routeplanning.entity.BusRoute;
import edu.swfu.routeplanning.entity.BusRoutePoint;
import edu.swfu.routeplanning.entity.BusRouteStop;

@Service
public class BusRouteServiceImpl extends TFeatureServiceImpl<BusRoute> implements IBusRouteService {
	
	@Autowired
	private IBusRouteDao dao;
	
	@Autowired
	private IBusRouteStopDao busRouteStopDao;
	
	@Autowired
	private IBusRoutePointDao busRoutePointDao;
	

	@Override
	public IFeatureDao<BusRoute> getDao() {
		return this.dao;
	}


	public List<BusRoute> selectPath() throws Exception {
		
		return this.getDao().selectByMethod("selectDirectRoutes");
	}

	@Override
	public int insert(BusRoute target, List<BusRouteStop> stops) throws Exception {
		int i=super.insert(target);
		for (BusRouteStop stop:stops)
			busRouteStopDao.insert(stop);
		
		return i;
	}
	

	public int collect(BusRoute target,List<BusRouteStop> lstBrs,List<BusRoutePoint> lstPoi) throws Exception {
		int i=getDao().insert(target);
		
		if (i<1)
			throw new Exception("insert fail");
		
		for (BusRouteStop stop:lstBrs)
			busRouteStopDao.insert(stop);
		
		for (BusRoutePoint point:lstPoi)
			busRoutePointDao.insert(point);

		
		return this.dao.iniRouteGeo(target);
	}
	
}
