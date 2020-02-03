package edu.swfu.routeplanning.dao.mybatis;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.swfu.gis.dao.mybatis.TFeatureDaoImpl;
import edu.swfu.routeplanning.dao.IBusRouteStopDao;
import edu.swfu.routeplanning.entity.BusRouteStop;

@Repository
@Primary
public class BusRouteStopDaoImpl extends TFeatureDaoImpl<BusRouteStop>  implements IBusRouteStopDao{

}
