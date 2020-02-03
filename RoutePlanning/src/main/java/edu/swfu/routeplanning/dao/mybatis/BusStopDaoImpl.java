package edu.swfu.routeplanning.dao.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.swfu.gis.dao.mybatis.TFeatureDaoImpl;
import edu.swfu.gis.entity.TGeometry;
import edu.swfu.routeplanning.dao.IBusStopDao;
import edu.swfu.routeplanning.entity.BusStop;


@Repository
@Primary
public class BusStopDaoImpl extends TFeatureDaoImpl<BusStop>  implements IBusStopDao{

	
	public String getStopId(String name,TGeometry geometry){
		Map<String,Object> para=new HashMap<String,Object>();
		para.put("name", name);
		para.put("geometry", geometry);
		
		return getSqlSession().selectOne(this.getMapperNameSpace()+".getStopId", para).toString() ;
	}

	@Override
	public String getStopCode(TGeometry geometry) {
		Map<String,Object> para=new HashMap<String,Object>();

		para.put("geometry", geometry);
		
		return getSqlSession().selectOne(this.getMapperNameSpace()+".getStopCode", para).toString() ;
	}
}
