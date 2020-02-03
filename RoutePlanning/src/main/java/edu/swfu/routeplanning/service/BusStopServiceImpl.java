package edu.swfu.routeplanning.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swfu.core.util.TQueryPara;
import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.gis.entity.TGeometry;
import edu.swfu.gis.service.TFeatureServiceImpl;
import edu.swfu.routeplanning.dao.IBusStopDao;
import edu.swfu.routeplanning.entity.BusStop;

@Service
public class BusStopServiceImpl extends TFeatureServiceImpl<BusStop> implements IBusStopService {
	
	@Autowired
	private IBusStopDao dao;
	

	@Override
	public IFeatureDao<BusStop> getDao() {
		return this.dao;
	}
	
	@Override
	public String getStopId(String code,TGeometry geometry) {
		return dao.getStopId(code,geometry);
	}

	@Override
	public String getStopCode(TGeometry geometry) {
		return dao.getStopCode(geometry);
	}	
	
	@Override
	public List<BusStop> selectByRoute(String busRouteId) throws Exception {
		TQueryPara para=new TQueryPara();
		para.addExp("bus_route_id", busRouteId);

		return dao.selectByMethod("selectByRoute", para);
	}

	@Override
	public List<BusStop> selectByRoute(String busRouteId, int sn1, int sn2) throws Exception {
		TQueryPara para=new TQueryPara();
		para.addExp("bus_route_id", busRouteId);
		para.addExp("sn_moreThan", sn1);
		para.addExp("sn_lessThan", sn2);
		return dao.selectByMethod("selectByRoute", para);
	}

}
