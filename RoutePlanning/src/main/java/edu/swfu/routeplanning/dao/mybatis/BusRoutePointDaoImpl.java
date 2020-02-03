package edu.swfu.routeplanning.dao.mybatis;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.swfu.gis.dao.mybatis.TFeatureDaoImpl;
import edu.swfu.routeplanning.dao.IBusRoutePointDao;
import edu.swfu.routeplanning.entity.BusRoutePoint;

@Repository
@Primary
public class BusRoutePointDaoImpl extends TFeatureDaoImpl<BusRoutePoint>  implements IBusRoutePointDao{
}
