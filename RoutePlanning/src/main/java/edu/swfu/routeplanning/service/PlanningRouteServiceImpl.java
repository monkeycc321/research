package edu.swfu.routeplanning.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.spatial.geometry.JGeometry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swfu.gis.entity.TMultiLine;
import edu.swfu.gis.entity.TPoint;
import edu.swfu.routeplanning.dao.IDirectRouteDao;
import edu.swfu.routeplanning.entity.DirectRoute;
import edu.swfu.routeplanning.entity.PlanningRoute;

@Service
public class PlanningRouteServiceImpl  implements IPlanningRouteService {
	
//	@Autowired
//	private IPlanningRouteDao dao;
	
	@Autowired
	private IDirectRouteDao directRouteDao;
	
//	@Override
//	public IFeatureDao getDao() {
//		return this.dao;
//	}
	
	private void slicingGeo(DirectRoute dr) {
		TMultiLine multiline=(TMultiLine) dr.getGeometry();
		
		double[][] coordinates=Arrays.copyOfRange(multiline.toCoordinates(),dr.getStopSn1()-1, dr.getStopSn2()-1);
		
		TMultiLine newGeo=new TMultiLine(multiline.getSrs(),multiline.getDim(),coordinates);
		
		
		dr.setGeometry(newGeo);
		
	}

	public List<PlanningRoute> selectDirect(Float x1,Float y1,Float x2,Float y2,Integer srid,Integer distance) throws Exception {
		Map<String,Object> para=new HashMap<String,Object>();
		para.put("origin", new JGeometry(x1,y1,srid));
		para.put("destination", new JGeometry(x2,y2,srid));
		para.put("distance",distance);
		
		TPoint origin=new TPoint(x1,y1);
		TPoint destination=new TPoint(x2,y2);
		Double radius=new Double(distance);
		

		List<DirectRoute> drs = this.directRouteDao.selectByMethod("selectDirect", para);
		List<PlanningRoute> result = new ArrayList<PlanningRoute>();
		for (DirectRoute dr : drs) {
			PlanningRoute pr = new PlanningRoute();
			pr.setOrigin(origin);
			pr.setDestination(destination);
			pr.setSearchRadius(radius);
			this.slicingGeo(dr);
			pr.getDirectRoutes().add(dr);
			result.add(pr);

		}
		
		return result;
	}

	public List<PlanningRoute> selectTransfer1(Float x1,Float y1,Float x2,Float y2,Integer srid,Integer distance) throws Exception {
		Map<String,Object> para=new HashMap<String,Object>();
		para.put("origin", new JGeometry(x1,y1,srid));
		para.put("destination", new JGeometry(x2,y2,srid));
		para.put("distance",distance);
		
		TPoint origin=new TPoint(x1,y1);
		TPoint destination=new TPoint(x2,y2);
		Double radius=new Double(distance);

		List<DirectRoute> drs=this.directRouteDao.selectByMethod("selectTransfer1",para);	
		List<PlanningRoute> result=new ArrayList<PlanningRoute>();
		int n=1;
		PlanningRoute pr=null;
		for (DirectRoute dr:drs) {
			if (n++%2==1) {
				pr=new PlanningRoute();
				pr.setOrigin(origin);
				pr.setDestination(destination);
				pr.setSearchRadius(radius);
				result.add(pr);
			} 
			
			this.slicingGeo(dr);
			pr.getDirectRoutes().add(dr);
		}
		
		return result;
	}

	public List<PlanningRoute> selectTransfer2(Float x1,Float y1,Float x2,Float y2,Integer srid,Integer distance) throws Exception {
		Map<String,Object> para=new HashMap<String,Object>();
		para.put("origin", new JGeometry(x1,y1,srid));
		para.put("destination", new JGeometry(x2,y2,srid));
		para.put("distance",distance);
		
		TPoint origin=new TPoint(x1,y1);
		TPoint destination=new TPoint(x2,y2);
		Double radius=new Double(distance);

		List<DirectRoute> drs=this.directRouteDao.selectByMethod("selectTransfer2",para);	
		List<PlanningRoute> result=new ArrayList<PlanningRoute>();
		int n=1;
		PlanningRoute pr=null;
		for (DirectRoute dr:drs) {
			if (n++%3==1) {
				pr=new PlanningRoute();
				pr.setOrigin(origin);
				pr.setDestination(destination);
				pr.setSearchRadius(radius);
				result.add(pr);
			} 
			
			this.slicingGeo(dr);
			pr.getDirectRoutes().add(dr);
		}
		
		return result;
	}

	public List<Map<String, Object>> selectPath() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}