package edu.swfu.routeplanning.dao.mybatis;

import java.util.Arrays;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.swfu.gis.dao.mybatis.TFeatureDaoImpl;
import edu.swfu.gis.entity.TMultiLine;
import edu.swfu.routeplanning.dao.IDirectRouteDao;
import edu.swfu.routeplanning.entity.DirectRoute;

@Repository
@Primary
public class DirectRouteDaoImpl extends TFeatureDaoImpl<DirectRoute> implements IDirectRouteDao{
	


}