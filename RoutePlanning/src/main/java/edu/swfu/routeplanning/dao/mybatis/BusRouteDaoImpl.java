package edu.swfu.routeplanning.dao.mybatis;


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.swfu.gis.dao.mybatis.TFeatureDaoImpl;
import edu.swfu.routeplanning.dao.IBusRouteDao;
import edu.swfu.routeplanning.entity.BusRoute;

@Repository
@Primary
public class BusRouteDaoImpl extends TFeatureDaoImpl<BusRoute>  implements IBusRouteDao{

	@Override
	public int iniRouteGeo(BusRoute target) throws Exception {
		Map<String,Object> para=new HashMap<String,Object>();
		para.put("id", target.getId());
		para.put("error", "");
		
		int i= getSqlSession().update(this.getMapperNameSpace()+".iniRouteGeo", para);
		String error="";
		if (para.get("error")!=null)
		  error=para.get("error").toString();
		
		if ("".equals(error))
			return i;
		else 
			throw new Exception(error);
	}


}
